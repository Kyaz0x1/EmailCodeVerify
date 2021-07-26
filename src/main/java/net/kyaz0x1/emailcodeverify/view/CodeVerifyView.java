package net.kyaz0x1.emailcodeverify.view;

import net.kyaz0x1.emailcodeverify.events.ButtonVerifyCodeClickEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class CodeVerifyView extends JFrame {

    private JLabel lblTitle, lblEnterEmail;
    private JTextField txtEmail;
    private JButton btnVerifyCode;

    public CodeVerifyView(){
        super("EmailCodeVerify v1.0.0");
        setSize(400, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        this.lblTitle = new JLabel("EmailCodeVerify");
        lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        lblTitle.setBounds(95, 10, 195, 40);

        add(lblTitle);

        this.lblEnterEmail = new JLabel("Informe o email abaixo para verificar o código:");
        lblEnterEmail.setBounds(68, 48, 280, 20);

        add(lblEnterEmail);

        this.txtEmail = new JTextField();
        txtEmail.setBounds(60, 70, 280, 20);

        add(txtEmail);

        this.btnVerifyCode = new JButton("Verificar código");
        btnVerifyCode.setBounds(120, 95, 150, 30);

        btnVerifyCode.addActionListener(new ButtonVerifyCodeClickEvent(txtEmail, btnVerifyCode));

        add(btnVerifyCode);
    }

}