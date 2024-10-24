import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class JTextPaneTest2 {
    private static JFrame frame;
    public static JPanel contentPanel;
    static Dictionary<URL, Image> cache;
    static JTextPane jTextPane;
    static URL urlArrow;

    public static void main(String[] args) {
        try {
            urlArrow = new URL("https:\\arrow.png");

            frame = new JFrame();
            frame.setBounds(200, 200, 800, 600);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().setLayout(new BorderLayout(0, 0));
            frame.setTitle("JTextPane HTML Images bug demo");

            jTextPane = new JTextPane();
            frame.getContentPane().add(contentPanel = new JPanel());


            contentPanel.setLayout(new BorderLayout(0, 0));
            contentPanel.add(jTextPane);


            StyleSheet styleSheet = new StyleSheet();

            styleSheet.addRule("table.masthead { background-color: #0073e7; width: 100%;}");
            styleSheet.addRule("table.masthead td { display: flex; color: #fff; font-size: 11px; font-family: Arial, Helvetica, sans-serif, Verdana; margin: 0; padding: 0;vertical-align: baseline; }");
            styleSheet.addRule("table.masthead td.logo { padding-top: 0px; padding-right: 0px; padding-left: 3px;text-align: top; }");
            styleSheet.addRule("table.masthead td.logo span{margin-right: 1px; margin-left: 1px; font: 14px Verdana, Arial; color: white; font-weight: 0;}");
//            styleSheet.addRule("table.masthead td.logo span{margin-bottom: 2px; margin-right: 1px; margin-left: 1px; height:5px; font: 14px Verdana, Arial; color: white; font-weight: 400;}");
            styleSheet.addRule("table.masthead td.logo img{margin-top: 5px;}");
//            styleSheet.addRule("table.masthead td.user_customer { text-align: right; vertical-align: middle; padding-right: 1px; padding-left: 10px; white-space: nowrap; color: white;}");

            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.setStyleSheet(styleSheet);
            HTMLDocument htmlDocument = (HTMLDocument) htmlEditorKit.createDefaultDocument();

            JTextPane jTextPane = new JTextPane();
            jTextPane.setContentType("text/html");
            jTextPane.setEditorKit(htmlEditorKit);
            jTextPane.setDocument(htmlDocument);
            jTextPane.setBackground(new Color(0, 115, 231));



            frame.getContentPane().add(jTextPane, BorderLayout.CENTER);
            cache = (Dictionary<URL, Image>) jTextPane.getDocument().getProperty("imageCache");
            if (cache == null) {
                cache = new Hashtable<URL, Image>();
                jTextPane.getDocument().putProperty("imageCache", cache);
            }
//            Image l_greenequalImage = new ImageIcon("D:\\Downloads\\ot logo in header.png").getImage().getScaledInstance(100, 22, Image.SCALE_SMOOTH);
            Image l_greenequalImage = new ImageIcon("D:\\Downloads\\core_masthead.png").getImage().getScaledInstance(400, 24, Image.SCALE_SMOOTH);
            cache.put(urlArrow, l_greenequalImage);
            frame.setVisible(true);

            java.util.List<String> miscInfo = new ArrayList<>();
            miscInfo.add("Universal Discovery and CMDB");
            miscInfo.add("user");
            miscInfo.add("3");

            String content = "<html><head></head><body><table class=\"masthead\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><td class=\"logo\"  nowrap >"
                    + "<img src=\"" + urlArrow + "\">"
                    + "<span>  CE 24.4</span>"
                    + "</td><td class=\"user_customer\" align=\"right\" >"
                    + miscInfo.get(1)
                    + "&nbsp;&nbsp;"
                    + miscInfo.get(2)
                    + "&nbsp;&nbsp;</td></table></body></html>";

            jTextPane.setText(content);
            jTextPane.validate();
            jTextPane.repaint();
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

    }

//    public void run() {
//        for (int i = 0; i < 5; i++) {
//            jTextPane.setText("<html><body bgcolor=\"#666666\"><center>Iteration " + i + " -> <img src=\"" + urlArrow + "\"> </center></body></html>");
//            jTextPane.validate();
//            jTextPane.repaint();
//            try {
//                Thread.currentThread().sleep(2000);
//            } catch (InterruptedException e) {
//                System.err.println(e);
//            }
//        }
//    }
}


