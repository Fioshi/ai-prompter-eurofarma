package br.com.datawave.ia.ai_project.factory;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.huggingface.HuggingFaceChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.time.Duration;

public class AiAssistentFactory {

    public static ChatLanguageModel  createHuggingFace(String token){
        return HuggingFaceChatModel.builder()
                .accessToken(token)
                .modelId("QuantFactory/Meta-Llama-3-8B-Instruct-GGUF")
                .temperature(0.2)
                .timeout(Duration.ofSeconds(300))
                .build();
    }

    public static ChatLanguageModel createLocalChatModel() {
        return OpenAiChatModel.builder()
                .baseUrl("http://localhost:1234/v1")
                .apiKey("ignore")
                .logRequests(true)
                .timeout(Duration.ofSeconds(300))
                .build();
    }

}
