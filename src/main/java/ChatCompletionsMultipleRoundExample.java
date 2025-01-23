
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessage;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessageRole;
import com.volcengine.ark.runtime.service.ArkService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ChatCompletionsMultipleRoundExample {
    public static void main(String[] args) {

        String apiKey = "ead21150-1dd9-4614-b0e7-eaa60e661b20";
        ArkService service = ArkService.builder().apiKey(apiKey).build();

        System.out.println("\n----- standard request -----");
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage1 = ChatMessage.builder().role(ChatMessageRole.SYSTEM).content("你是豆包，是由字节跳动开发的 AI 人工智能助手").build();
        final ChatMessage systemMessage2 = ChatMessage.builder().role(ChatMessageRole.SYSTEM).content("我给你提供一段xml文档，这个文档包含一些命令行的执行和结果。其中CMD表示的是执行的命令，RESULT表示的是命令执行结果。请你告诉我一共执行了哪些命令以及结果是什么").build();
        final ChatMessage userMessage = ChatMessage.builder().role(ChatMessageRole.USER).content("你是谁").build();

        messages.add(systemMessage1);
        messages.add(systemMessage2);
        messages.add(userMessage);

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model("ep-20241024182717-tj7rz")
                .messages(messages)
                .build();

        service.createChatCompletion(chatCompletionRequest).getChoices().forEach(choice -> System.out.println(choice.getMessage().getContent()));

        final ChatMessage userMessage2 = ChatMessage.builder().role(ChatMessageRole.USER).content("1+1等于几").build();
        ChatCompletionRequest chatCompletionRequest2 = ChatCompletionRequest.builder()
                .model("ep-20241024182717-tj7rz")
                .messages(Arrays.asList(systemMessage1, userMessage2))
                .build();
        service.createChatCompletion(chatCompletionRequest2).getChoices().forEach(choice -> System.out.println(choice.getMessage().getContent()));

        // shutdown service
        service.shutdownExecutor();
    }

}