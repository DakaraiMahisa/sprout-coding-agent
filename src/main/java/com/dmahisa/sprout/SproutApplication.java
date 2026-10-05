package com.dmahisa.sprout;

import org.springaicommunity.agent.tools.FileSystemTools;
import org.springaicommunity.agent.tools.GlobTool;
import org.springaicommunity.agent.tools.GrepTool;
import org.springaicommunity.agent.tools.ShellTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class SproutApplication {

	public static void main(String[] args) {
		SpringApplication.run(SproutApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(ChatClient.Builder builder) {

		return args -> {

			ChatMemory chatMemory = MessageWindowChatMemory.builder()
					.maxMessages(50)
					.build();

			ChatClient chatClient = builder
					.defaultSystem("""
                        You are a helpful coding assistant. You have access to tools
                        for reading files, searching code, running shell commands,
                        and editing files. Use them to help the user with their codebase.

                        Current directory: %s
                        """.formatted(System.getProperty("user.dir")))
					.defaultTools(
							FileSystemTools.builder().build(),
							GrepTool.builder().build(),
							GlobTool.builder().build(),
							ShellTools.builder().build()
					)
					.defaultAdvisors(
							MessageChatMemoryAdvisor.builder(chatMemory)
									.build()
					)
					.build();

			var scanner = new Scanner(System.in);

			System.out.println(
					"🤖 Coding Agent Ready. Ask me anything about your codebase!"
			);

			while (true) {

				System.out.print("\n> ");

				String input = scanner.nextLine();

				if ("exit".equalsIgnoreCase(input.trim())) {
					break;
				}

				String response = chatClient.prompt(input)
						.advisors(advisor -> advisor.param(
								ChatMemory.CONVERSATION_ID,
								"coding-agent"
						))
						.toolContext(Map.of(
								"workingDir",
								System.getProperty("user.dir")
						))
						.call()
						.content();

				System.out.println("\n" + response);
			}
		};
	}
}
