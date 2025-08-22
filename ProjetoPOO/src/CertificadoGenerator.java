import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class CertificadoGenerator {

    public static void gerarCertificado(String nome) {
        try {
            // Carrega a imagem base do certificado (ajuste o caminho conforme necessário)
            BufferedImage certificado = ImageIO.read(new File("certificado_base.jpg"));

            // Obtém o Graphics2D da imagem
            Graphics2D g2d = certificado.createGraphics();

            // Configura a fonte e a cor
            g2d.setFont(new Font("Arial", Font.BOLD, 32));
            g2d.setColor(Color.WHITE);

            // Define a posição do texto (ajuste conforme a sua imagem)
            int x = 445;  // ajuste se necessário
            int y = 570;  // ajuste se necessário

            // Desenha o nome na imagem
            g2d.drawString(nome, x, y);

            // Finaliza
            g2d.dispose();

            // Define o nome do arquivo
            String nomeArquivo = "certificado_" + nome.replaceAll("\\s+", "_") + ".jpg";

            // Salva a imagem como JPG
            ImageIO.write(certificado, "jpg", new File(nomeArquivo));

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Certificado gerado: " + nomeArquivo);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o certificado: " + ex.getMessage());
        }
    }
}


