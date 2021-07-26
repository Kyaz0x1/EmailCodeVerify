package net.kyaz0x1.emailcodeverify;

import net.kyaz0x1.emailcodeverify.view.CodeVerifyView;

import javax.swing.SwingUtilities;

public class EmailCodeVerify {

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new CodeVerifyView().setVisible(true));
    }

}