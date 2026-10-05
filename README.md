# 🌱 Sprout

A terminal-based Spring AI coding assistant for exploring and working with your local codebase.

Built with **Spring Boot**, **Spring AI**, and **Google GenAI**.

![Java](https://img.shields.io/badge/Java-27-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring AI](https://img.shields.io/badge/Spring%20AI-2.0.1-0B6E4F?style=for-the-badge)
![Gemini](https://img.shields.io/badge/Google%20GenAI-Gemini%203.5%20Flash-4285F4?style=for-the-badge&logo=google&logoColor=white)

---

## ✨ Overview

`Sprout` is an interactive command-line coding assistant that helps you inspect and work on a local project. It starts a chat session in your terminal and can use built-in tools to:

- 🔎 search for code patterns
- 📂 inspect files and directories
- 🧰 run shell commands in the current workspace
- 🧠 maintain short conversation history for follow-up questions

It is designed to be used as a local companion while you are developing in the `sprout` workspace.

---

## 🧩 What it does

When you launch the app, it:

1. Starts a Spring Boot application.
2. Creates an interactive chat client backed by Google GenAI.
3. Provides coding-focused tools for file search, globbing, filesystem access, and shell execution.
4. Keeps a small chat memory window so you can continue a task across multiple prompts.
5. Lets you type `exit` to close the session cleanly.

---

## 🛠️ Tools used by the assistant

The assistant is wired with the following tools from `spring-ai-agent-utils`:

| Tool | Purpose |
|------|---------|
| `FileSystemTools` | Read and inspect files in the workspace |
| `GrepTool` | Search for text or patterns inside files |
| `GlobTool` | Discover files by path pattern |
| `ShellTools` | Run shell commands from the terminal |

These tools are what make the assistant useful for navigating and understanding a codebase from the command line.

---

## 🤖 Model used

`Sprout` is configured to use:

- **Provider:** Google GenAI via Spring AI
- **Model:** `gemini-3.5-flash`

The API key is read from the environment variable:

```text
GEMINI_API_KEY
```

Make sure that variable is set before starting the application.

---

## 📦 Project stack

- **Language:** Java 27
- **Framework:** Spring Boot 4.1.1
- **AI layer:** Spring AI 2.0.1
- **Testing:** Spring Boot Test / JUnit 5

---

## 🚀 Getting started

### 1) Prerequisites

Make sure you have:

- ✅ Java 27 installed
- ✅ Maven available, or use the included Maven Wrapper
- ✅ A valid Google GenAI API key

### 2) Set your API key

#### Windows PowerShell

```powershell
$env:GEMINI_API_KEY="your-api-key-here"
```

#### macOS / Linux

```bash
export GEMINI_API_KEY="your-api-key-here"
```

---

## ▶️ How to run

### Using Maven Wrapper

#### Windows PowerShell

```powershell
.\mvnw.cmd spring-boot:run
```

#### macOS / Linux

```bash
./mvnw spring-boot:run
```

### Build and run the JAR

```bash
./mvnw clean package
java -jar target/sprout-0.0.1-SNAPSHOT.jar
```

> On Windows, use `mvnw.cmd` instead of `./mvnw`.

---

## 🧪 Run tests

```bash
./mvnw test
```

The project includes a basic Spring Boot context test to verify the application starts successfully.

---

## 💬 Using the assistant

Once the app starts, you will see a prompt like this:

```text
🤖 Coding Agent Ready. Ask me anything about your codebase!
```

You can then ask questions such as:

- "Show me where the assistant tools are configured."
- "Search for the main application entry point."
- "Explain how the API key is loaded."

To exit the session, type:

```text
exit
```

---

## 📁 Key files

- `src/main/java/com/dmahisa/sprout/SproutApplication.java` — application entry point and interactive agent loop
- `src/main/resources/application.yaml` — Spring AI / Gemini configuration
- `src/test/java/com/dmahisa/sprout/SproutApplicationTests.java` — smoke test for application startup

---

## 📚 Additional notes

- The assistant keeps a short memory window of recent messages to support follow-up questions.
- The current working directory is exposed to the agent so it can reason about the local workspace.
- Logging is configured for readable console output.

---

## 📖 References

- [Spring Boot Maven Plugin Guide](https://docs.spring.io/spring-boot/4.1.1/maven-plugin)
- [Spring AI Google GenAI Chat Docs](https://docs.spring.io/spring-ai/reference/api/chat/google-genai-chat.html)
- [Apache Maven Documentation](https://maven.apache.org/guides/index.html)

---

*Built for local, terminal-first coding assistance.*


