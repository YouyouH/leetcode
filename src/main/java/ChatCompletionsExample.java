
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessage;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessageRole;
import com.volcengine.ark.runtime.service.ArkService;

import java.util.ArrayList;
import java.util.List;


public class ChatCompletionsExample {
    public static void main(String[] args) {

        String apiKey = "ead21150-1dd9-4614-b0e7-eaa60e661b20";
        ArkService service = ArkService.builder().apiKey(apiKey).build();

        System.out.println("\n----- standard request -----");
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage1 = ChatMessage.builder().role(ChatMessageRole.SYSTEM).content("你是豆包，是由字节跳动开发的 AI 人工智能助手").build();
        final ChatMessage systemMessage2 = ChatMessage.builder().role(ChatMessageRole.SYSTEM).content("我给你提供一段xml文档，这个文档包含一些命令行的执行和结果。其中CMD表示的是执行的命令，RESULT表示的是命令执行结果。请你告诉我一共执行了哪些命令以及结果是什么").build();
        final ChatMessage userMessage = ChatMessage.builder().role(ChatMessageRole.USER).content("<EXEC start=\"2024-08-29 09:04:46\" duration=\"63\" CMD=\"ver\" RESULT=\"Microsoft Windows [Version 10.0.17763.6189]\" />\n" +
                "\t<log start=\"2024-08-29 09:04:46\" severity=\"debug\">Windows ntcmd detected</log>\n" +
                "\t<EXEC start=\"2024-08-29 09:04:46\" duration=\"62\" CMD=\"ver\" RESULT=\"Microsoft Windows [Version 10.0.17763.6189]\" />\n" +
                "\t<EXEC start=\"2024-08-29 09:04:46\" duration=\"63\" CMD=\"echo %ERRORLEVEL%\" RESULT=\"0\" />\n" +
                "\t<log start=\"2024-08-29 09:04:46\" severity=\"debug\">adding alternate cmd='wmic OS Get CodeSet &lt; %SystemRoot%\\win.ini'</log>\n" +
                "\t<log start=\"2024-08-29 09:04:46\" severity=\"debug\">adding alternate cmd='%WINDIR%\\system32\\wbem\\wmic OS Get CodeSet &lt; %SystemRoot%\\win.ini'</log>\n" +
                "\t<EXEC start=\"2024-08-29 09:04:46\" duration=\"437\">\n" +
                "\t\t<CMD>[CDATA: wmic OS Get CodeSet &lt; %SystemRoot%\\win.ini]</CMD>\n" +
                "\t\t<RESULT>[CDATA: CodeSet  \n" +
                "1252]</RESULT>\n" +
                "\t</EXEC>\n" +
                "\t<EXEC start=\"2024-08-29 09:04:46\" duration=\"63\" CMD=\"echo %ERRORLEVEL%\" RESULT=\"0\" />\n" +
                "\t<log start=\"2024-08-29 09:04:46\" severity=\"debug\">command='wmic OS Get CodeSet &lt; %SystemRoot%\\win.ini' ended successfully</log>\n" +
                "\t<log start=\"2024-08-29 09:04:46\" severity=\"debug\">adding alternate cmd='wmic OS Get OSLanguage &lt; %SystemRoot%\\win.ini'</log>\n" +
                "\t<log start=\"2024-08-29 09:04:46\" severity=\"debug\">adding alternate cmd='%WINDIR%\\system32\\wbem\\wmic OS Get OSLanguage &lt; %SystemRoot%\\win.ini'</log>\n" +
                "\t<EXEC start=\"2024-08-29 09:04:46\" duration=\"125\">\n" +
                "\t\t<CMD>[CDATA: wmic OS Get OSLanguage &lt; %SystemRoot%\\win.ini]</CMD>\n" +
                "\t\t<RESULT>[CDATA: OSLanguage  \n" +
                "1033]</RESULT>\n" +
                "\t</EXEC>\n" +
                "\t<EXEC start=\"2024-08-29 09:04:46\" duration=\"62\" CMD=\"echo %ERRORLEVEL%\" RESULT=\"0\" />").build();

        messages.add(systemMessage1);
        messages.add(systemMessage2);
        messages.add(userMessage);

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model("ep-20241024182717-tj7rz")
                .messages(messages)
                .build();

        service.createChatCompletion(chatCompletionRequest).getChoices().forEach(choice -> System.out.println(choice.getMessage().getContent()));

        // shutdown service
        service.shutdownExecutor();
    }

}