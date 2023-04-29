import com.itextpdf.text.BaseColor;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
//import javax.swing.text.Document;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

//import static com.sun.org.apache.xerces.internal.impl.xs.SchemaGrammar.resize;

public class CV {
  //  private final byte[] path;
    private JPanel cvPanel;
    private JComboBox comboBox1;
    private JTextField workE;
    private JTextField collage;
    private JTextField skill1;
    private JTextField skill2;
    private JTextField skill3;
    private JTextField email;
    private JTextField contact;
    private JTextField address;
    private JTextField name;
    private JButton SELECTIMAGEButton;
    private JButton GENERATERESUMEButton;
    private JTextField location;
    private JLabel RESUMEBUILDERLabel;
    private JLabel NAMELabel;
    private JLabel ADDRESSLabel;
    private JLabel CONTACTLabel;
    private JLabel EMAILLabel;
    private JLabel SKILLSLabel;
    private JLabel COLLAGELabel;
    private JLabel WORKEXPERIENCELabel;
    private JLabel img;
    private JTextField skill4;
    JFrame frame = new JFrame();
    public CV() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(cvPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        SELECTIMAGEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg", "png");
                fileChooser.addChoosableFileFilter(filter);
                int rs = fileChooser.showSaveDialog(null);
                if (rs == JFileChooser.APPROVE_OPTION) {
                    File selectedImage = fileChooser.getSelectedFile();
                    location.setText(selectedImage.getAbsolutePath());
                    img.setIcon(resize(location.getText()));


                }
            }


        });

        GENERATERESUMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(name.getText()==null || contact.getText()==null || address.getText()==null || email.getText()==null){
                    JOptionPane.showMessageDialog(null,"Please fill all Information");
                }else{
                    try {
                        String nameOfFile = "C:\\New _older\\myy.pdf";
                        Document myDocument = new Document();

                        PdfWriter.getInstance(myDocument, new FileOutputStream(nameOfFile));
                        myDocument.open();
                        com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(location.getText());
                        img.setAbsolutePosition(473f, 750f);
                        img.scaleAbsolute(80f, 78f);
                        PdfPTable table = new PdfPTable(2);
                        myDocument.add(img);
                        myDocument.add(new Paragraph(name.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 28, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("", FontFactory.getFont(FontFactory.TIMES_BOLD, 28, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("", FontFactory.getFont(FontFactory.TIMES_BOLD, 28, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("", FontFactory.getFont(FontFactory.TIMES_BOLD, 28, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("---------------------------------------------------------"));
                        myDocument.add(new Paragraph("Contact Details", FontFactory.getFont(FontFactory.TIMES_BOLD, 32, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph(email.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 28, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph(contact.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 28, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph(address.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 28, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("---------------------------------------------------------"));
                        myDocument.add(new Paragraph("SKILLS", FontFactory.getFont(FontFactory.TIMES_BOLD, 32, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));

                        table.addCell(skill1.getText());
                        table.addCell(skill2.getText());
                        table.addCell(skill3.getText());
                        table.addCell(skill4.getText());

                        myDocument.add(table);
                        myDocument.add(new Paragraph("---------------------------------------------------------"));
                        myDocument.add(new Paragraph("QUALIFICATION", FontFactory.getFont(FontFactory.TIMES_BOLD, 32, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph(collage.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 28, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("WORK EXPERIENCE", FontFactory.getFont(FontFactory.TIMES_BOLD, 32, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("" + workE.getSelectedText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 28, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));

                        myDocument.close();
                        JOptionPane.showMessageDialog(null, "CV was Succesfully Gaenerated");
                    }catch (Exception ex){
                       JOptionPane.showMessageDialog(null,ex);
                    }


                         }

                }


        });
    }

        private ImageIcon resize(String path) {
            ImageIcon myImg=new ImageIcon(path);
            Image image=myImg.getImage();
            Image newImage=image.getScaledInstance(200,200,Image.SCALE_SMOOTH);

            ImageIcon finalImage=new ImageIcon(newImage);
            return finalImage;


    }
}
