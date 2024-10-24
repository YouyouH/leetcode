import javax.swing.*;
import javax.swing.text.EditorKit;
import java.awt.*;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;

public class JTextPaneTest {
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
            final EditorKit l_kit = jTextPane.getEditorKitForContentType("text/html");
            jTextPane.setEditable(false);
            jTextPane.setEditorKit(l_kit);
            frame.getContentPane().add(jTextPane, BorderLayout.CENTER);
            cache = (Dictionary<URL, Image>) jTextPane.getDocument().getProperty("imageCache");
            if (cache == null) {
                cache = new Hashtable<URL, Image>();
                jTextPane.getDocument().putProperty("imageCache", cache);
            }
            Image l_greenequalImage = new ImageIcon("D:\\Downloads\\ot logo in header.png").getImage().getScaledInstance(240, 24, java.awt.Image.SCALE_SMOOTH);
            cache.put(urlArrow, l_greenequalImage);
            frame.setVisible(true);
            jTextPane.setText("<html><body bgcolor=\"#666666\"><center>Iteration -> <img src=\"" + urlArrow + "\""+"style=\"width: 2000px;\""+"> </center></body></html>");
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


