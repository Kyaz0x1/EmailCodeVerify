package net.kyaz0x1.emailcodeverify.events;

import net.kyaz0x1.emailcodeverify.email.EmailSender;
import net.kyaz0x1.emailcodeverify.utils.RandomUtils;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonVerifyCodeClickEvent implements ActionListener {

    private JTextField txtEmail;
    private JButton btnVerifyCode;

    public static String randomCode = "";

    public ButtonVerifyCodeClickEvent(JTextField txtEmail, JButton btnVerifyCode){
        this.txtEmail = txtEmail;
        this.btnVerifyCode = btnVerifyCode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnVerifyCode.setEnabled(false);
        new Thread(() -> {
            final String email = txtEmail.getText();
            if(!isEmail(email)){
                JOptionPane.showMessageDialog(null, "O email informado é inválido!", "EmailCodeVerify", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ButtonVerifyCodeClickEvent.randomCode = RandomUtils.randomNumerics(5);
            EmailSender.send(email, "EmailCodeVerify", "Seu código é: " + randomCode);

            boolean verified = false;

            while(!verified){
                final String value = JOptionPane.showInputDialog("Digite o código enviado para o email " + email);

                if(value == null)
                    continue;

                if(!value.equals(randomCode)){
                    JOptionPane.showMessageDialog(null, "O código informado é inválido!", "EmailCodeVerify", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                verified = true;
                JOptionPane.showMessageDialog(null, "Parabéns! O código informado é válido!");
                System.exit(0);
            }
        }).start();
    }

    private boolean isEmail(String value){
        return value.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }

}