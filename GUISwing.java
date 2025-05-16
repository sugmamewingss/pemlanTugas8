import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class GUISwing extends JFrame {
    private JTextField txtNama, txtNIM, txtEmail, txtTelepon;
    private JComboBox<String> cbProdi, cbSemester;
    private JRadioButton rbLaki, rbPerempuan;
    private JTextArea taAlamat;
    private JCheckBox cbConfirm;
    private JButton btnSubmit, btnReset;

    public GUISwing() {
        setTitle("FORM DAFTAR ULANG MAHASISWA BARU");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel utama dengan border layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(240, 248, 255));

        // Header dengan gambar dan judul
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(240, 248, 255));

        JLabel lblTitle = new JLabel("FORMULIR DAFTAR ULANG MAHASISWA BARU", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0, 51, 102));

        JLabel lblLogo = new JLabel(new ImageIcon("university_logo.png")); // gaada logo untuk sementara
        lblLogo.setPreferredSize(new Dimension(80, 80));
        lblLogo.setHorizontalAlignment(JLabel.CENTER);

        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(lblTitle, BorderLayout.CENTER);

        // Panel form dengan grid bag layout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Baris 0: Nama Lengkap
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Nama Lengkap:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtNama = new JTextField(25);
        formPanel.add(txtNama, gbc);

        // Baris 1: NIM
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("NIM:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtNIM = new JTextField(25);
        formPanel.add(txtNIM, gbc);

        // Baris 2: Jenis Kelamin
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Jenis Kelamin:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");
        ButtonGroup bgGender = new ButtonGroup();
        bgGender.add(rbLaki);
        bgGender.add(rbPerempuan);
        genderPanel.add(rbLaki);
        genderPanel.add(rbPerempuan);
        genderPanel.setBackground(Color.WHITE);
        formPanel.add(genderPanel, gbc);

        // Baris 3: Program Studi
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Program Studi:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        String[] prodiList = { "-- Pilih Program Studi --", "Teknik Informatika", "Sistem Informasi",
                "Teknologi Informasi", "Teknik Komputer", "Pendidikan Teknologi Informasi" };
        cbProdi = new JComboBox<>(prodiList);
        formPanel.add(cbProdi, gbc);

        // Baris 4: Semester
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Semester Masuk:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        String[] semesterList = { "-- Pilih Semester --", "1", "2", "3", "4", "5", "6", "7", "8" };
        cbSemester = new JComboBox<>(semesterList);
        formPanel.add(cbSemester, gbc);

        // Baris 5: Email
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtEmail = new JTextField(25);
        formPanel.add(txtEmail, gbc);

        // Baris 6: Nomor Telepon
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Nomor Telepon:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtTelepon = new JTextField(25);
        formPanel.add(txtTelepon, gbc);

        // Baris 7: Alamat
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Alamat:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        taAlamat = new JTextArea(3, 25);
        taAlamat.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(taAlamat);
        formPanel.add(scrollPane, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Baris 8: Konfirmasi
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        cbConfirm = new JCheckBox("Saya menyatakan bahwa data yang saya isi adalah benar");
        cbConfirm.setBackground(Color.WHITE);
        formPanel.add(cbConfirm, gbc);

        // Panel tombol
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(240, 248, 255));

        btnReset = new JButton("Reset");
        btnReset.setBackground(new Color(220, 220, 220));
        btnReset.setPreferredSize(new Dimension(120, 30));
        btnReset.addActionListener(e -> resetForm());

        btnSubmit = new JButton("Submit");
        btnSubmit.setBackground(new Color(220, 220, 220));
        btnSubmit.setPreferredSize(new Dimension(120, 30));
        btnSubmit.addActionListener(e -> submitForm());

        buttonPanel.add(btnReset);
        buttonPanel.add(btnSubmit);

        // Menambahkan komponen ke panel utama
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void resetForm() {
        txtNama.setText("");
        txtNIM.setText("");
        txtEmail.setText("");
        txtTelepon.setText("");
        taAlamat.setText("");
        cbProdi.setSelectedIndex(0);
        cbSemester.setSelectedIndex(0);
        rbLaki.setSelected(false);
        rbPerempuan.setSelected(false);
        cbConfirm.setSelected(false);
    }

    private void submitForm() {
        // Validasi form
        if (txtNama.getText().trim().isEmpty() ||
                txtNIM.getText().trim().isEmpty() ||
                txtEmail.getText().trim().isEmpty() ||
                txtTelepon.getText().trim().isEmpty() ||
                taAlamat.getText().trim().isEmpty() ||
                cbProdi.getSelectedIndex() == 0 ||
                cbSemester.getSelectedIndex() == 0 ||
                (!rbLaki.isSelected() && !rbPerempuan.isSelected()) ||
                !cbConfirm.isSelected()) {

            JOptionPane.showMessageDialog(this,
                    "Harap isi semua kolom dan centang pernyataan!",
                    "Form Tidak Lengkap",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validasi format email sederhana
        if (!txtEmail.getText().contains("@") || !txtEmail.getText().contains(".")) {
            JOptionPane.showMessageDialog(this,
                    "Format email tidak valid!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi NIM harus angka
        try {
            Long.parseLong(txtNIM.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "NIM harus berupa angka!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Konfirmasi sebelum submit
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Apakah anda yakin data yang Anda isi sudah benar?",
                "Konfirmasi",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.OK_OPTION) {
            // Tampilkan data yang diisi
            showDataSummary();
        }
    }

    private void showDataSummary() {
        JFrame summaryFrame = new JFrame("Data Mahasiswa");
        summaryFrame.setSize(500, 400);
        summaryFrame.setLocationRelativeTo(this);
        summaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel summaryPanel = new JPanel(new BorderLayout(10, 10));
        summaryPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        summaryPanel.setBackground(new Color(240, 248, 255));

        JLabel lblTitle = new JLabel("DATA MAHASISWA", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setForeground(new Color(0, 51, 102));

        // Panel data
        JPanel dataPanel = new JPanel(new GridLayout(0, 2, 10, 5));
        dataPanel.setBackground(Color.WHITE);
        dataPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));

        // Tambahkan data ke panel
        Map<String, String> data = new HashMap<>();
        data.put("Nama Lengkap", txtNama.getText());
        data.put("NIM", txtNIM.getText());
        data.put("Jenis Kelamin", rbLaki.isSelected() ? "Laki-laki" : "Perempuan");
        data.put("Program Studi", cbProdi.getSelectedItem().toString());
        data.put("Semester Masuk", cbSemester.getSelectedItem().toString());
        data.put("Email", txtEmail.getText());
        data.put("Nomor Telepon", txtTelepon.getText());
        data.put("Alamat", taAlamat.getText());

        for (Map.Entry<String, String> entry : data.entrySet()) {
            JLabel lblKey = new JLabel(entry.getKey() + ":");
            lblKey.setFont(new Font("Arial", Font.BOLD, 12));

            JLabel lblValue = new JLabel(entry.getValue());

            dataPanel.add(lblKey);
            dataPanel.add(lblValue);
        }

        // Tombol tutup
        JButton btnClose = new JButton("Tutup");
        btnClose.addActionListener(e -> summaryFrame.dispose());
        btnClose.setBackground(new Color(220, 220, 220));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.add(btnClose);

        summaryPanel.add(lblTitle, BorderLayout.NORTH);
        summaryPanel.add(dataPanel, BorderLayout.CENTER);
        summaryPanel.add(buttonPanel, BorderLayout.SOUTH);

        summaryFrame.add(summaryPanel);
        summaryFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Set look and feel untuk tampilan yang lebih modern
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            GUISwing form = new GUISwing();
            form.setVisible(true);
        });
    }
}