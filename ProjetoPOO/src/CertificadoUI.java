import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class CertificadoUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CertificadoUI().criarInterface());
    }

    private void criarInterface() {
        JFrame frame = new JFrame("Gerador de Certificado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setLocationRelativeTo(null); // Centraliza a janela

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBackground(Color.BLACK);

        // -------- LOGO --------
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/imagens/logo.jpeg"));
        Image image = originalIcon.getImage();
        Image novaImagem = image.getScaledInstance(350, 250, Image.SCALE_SMOOTH);
        ImageIcon iconRedimensionado = new ImageIcon(novaImagem);

        JLabel logoLabel = new JLabel(iconRedimensionado);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelPrincipal.add(Box.createVerticalStrut(20));
        painelPrincipal.add(logoLabel);
        painelPrincipal.add(Box.createVerticalStrut(20));

        // -------- FORMULÁRIO --------
        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new BoxLayout(formularioPanel, BoxLayout.Y_AXIS));
        formularioPanel.setOpaque(false);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setForeground(Color.WHITE);
        nomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField nomeField = new JTextField(20);
        nomeField.setMaximumSize(new Dimension(200, 30));
        nomeField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton gerarButton = new JButton("Gerar Certificado");
        gerarButton.setBackground(new Color(59, 167, 59));
        gerarButton.setFocusPainted(true);
        gerarButton.setBorder(new LineBorder(Color.WHITE, 2));
        gerarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        gerarButton.addActionListener(e -> {
            String nome = nomeField.getText().trim();
            if (!nome.isEmpty()) {
                CertificadoGenerator.gerarCertificado(nome);
            } else {
                JOptionPane.showMessageDialog(frame, "Por favor, insira o nome.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        formularioPanel.add(nomeLabel);
        formularioPanel.add(Box.createVerticalStrut(5));
        formularioPanel.add(nomeField);
        formularioPanel.add(Box.createVerticalStrut(10));
        formularioPanel.add(gerarButton);

        painelPrincipal.add(formularioPanel);
        painelPrincipal.add(Box.createVerticalStrut(20));

        // -------- PERSONAGEM --------
        ImageIcon personagemIcon = new ImageIcon(getClass().getResource("/imagens/personagem.png"));
        Image personagemImg = personagemIcon.getImage();
        Image personagemRedim = personagemImg.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon personagemRedimensionado = new ImageIcon(personagemRedim);

        JLabel personagemLabel = new JLabel(personagemRedimensionado);
        personagemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelPrincipal.add(personagemLabel);
        painelPrincipal.add(Box.createVerticalStrut(20));

        // -------- RODAPÉ --------
        JLabel rodapeLabel = new JLabel("Simulação de evento para prática de Java e entrega do projeto.");
        rodapeLabel.setForeground(Color.WHITE);
        rodapeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        rodapeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelPrincipal.add(rodapeLabel);

        JScrollPane scrollPane = new JScrollPane(painelPrincipal);
        scrollPane.setBorder(null);

        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
