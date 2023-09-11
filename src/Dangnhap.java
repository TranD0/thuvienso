import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dangnhap extends JFrame {
    public Dangnhap() {
        this.setTitle("Thư viện số");
        this.setSize(500, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(null);
        //tieu de
        JLabel lbtieude= new JLabel("Thư viện số");
        lbtieude.setBounds(200,20,120,35);
        lbtieude.setFont(new Font("Tahoma",Font.BOLD,20));
        lbtieude.setForeground(Color.PINK);
        panel.add(lbtieude);
        //acc
        JLabel lbuser = new JLabel("Tài khoản");
        lbuser.setBounds(120,65,80,25);
        JTextField txuser = new JTextField();
        txuser.setBounds(200,65,200,25);
        panel.add(lbuser);
        panel.add(txuser);
        //pass
        JLabel lbpass = new JLabel("Mật khẩu");
        lbpass.setBounds(120,100,80,25);
        JPasswordField txpass = new JPasswordField();
        txpass.setBounds(200,100,200,25);
        panel.add(lbpass);
        panel.add(txpass);
        //quen mk
        JLabel lbquenmk = new JLabel("Quên mật khẩu?");
        lbquenmk.setBounds(200,175,100,25);
        lbquenmk.setFont(new Font("Tahoma",Font.ITALIC,10));
        lbquenmk.setForeground(Color.PINK);
        lbquenmk.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Quenmk().setVisible(true);
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        panel.add(lbquenmk);
        //hien thong báo
        JLabel lbsaimk = new JLabel();
        lbsaimk.setBounds(200,125,200,25);
        lbsaimk.setFont(new Font("Tahoma",Font.ITALIC,10));
        lbsaimk.setForeground(Color.RED);
        panel.add(lbsaimk);
        //button dang nhap
        JButton jbtLogin = new JButton("Đăng nhập");
        jbtLogin.setFont(new Font("Tahoma",Font.BOLD,10));
        jbtLogin.setFocusable(false);//tat vien xung quanh button
        jbtLogin.setBounds(200,150,90,25);
        jbtLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tk=txuser.getText();
                String mk=txpass.getText();
                String fileName = "nguoidung.txt";
                String ten,email,taikhon,matkha;
                try
                {
                    BufferedReader in = new BufferedReader( new FileReader( fileName  ) );
                    ten=in.readLine();
                    taikhon = in.readLine();
                    email=in.readLine();
                    matkha=in.readLine();
                    while ( taikhon != null )
                    {
                        if(tk.equals(taikhon)&&mk.equals(matkha))
                        new Giaodien().setVisible(true);
                        taikhon = in.readLine();
                        email=in.readLine();
                        matkha=in.readLine();
                    }
                    in.close();
                    lbsaimk.setText("Tài khoản hoặc mật khẩu không đúng!!!");
                }
                catch ( IOException iox )
                {
                    System.out.println("Problem reading " + fileName );
                }

            }
        });
        panel.add(jbtLogin);
        //button dang ki
        JButton jbtDangki = new JButton("Đăng kí");
        jbtDangki.setFont(new Font("Tahoma",Font.BOLD,10));
        jbtDangki.setFocusable(false);//tat vien xung quanh button
        jbtDangki.setBounds(310,150,90,25);
        jbtDangki.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e)
            {
                new Dangki().setVisible(true);
            }
        });
        panel.add(jbtDangki);

        this.setVisible(true);
    }


}
