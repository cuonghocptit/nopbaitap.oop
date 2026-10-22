import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Lớp SanPham: lưu thông tin một sản phẩm của cửa hàng phụ kiện máy tính.
 * Thuộc tính để private, truy cập qua getter/setter (đóng gói).
 */
public class SanPham {
    // ===== Thuộc tính (private) =====
    private String maSP;
    private String tenSP;
    private double donGia;
    private int soLuongTon;

    // ===== 3 constructor =====

    // 1) Không tham số
    public SanPham() {
    }

    // 2) Chỉ có mã và tên (hàng mới về, chưa có giá)
    public SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    // 3) Đủ 4 tham số - gọi lại constructor 2 tham số bằng this(...)
    public SanPham(String maSP, String tenSP, double donGia, int soLuongTon) {
        this(maSP, tenSP);
        setDonGia(donGia);
        setSoLuongTon(soLuongTon);
    }

    // ===== Getter / Setter =====
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDonGia() {
        return donGia;
    }

    // Giá không được âm
    public void setDonGia(double donGia) {
        if (donGia >= 0) {
            this.donGia = donGia;
        }
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    // Số lượng tồn không được âm
    public void setSoLuongTon(int soLuongTon) {
        if (soLuongTon >= 0) {
            this.soLuongTon = soLuongTon;
        }
    }

    // ===== Phương thức =====

    public static String dinhDangTien(double tien) {
        DecimalFormatSymbols kyHieu = new DecimalFormatSymbols();
        kyHieu.setGroupingSeparator('.');
        return new DecimalFormat("#,##0", kyHieu).format(tien);
    }

    public void hienThi() {
        System.out.printf("%-6s%-16s%9s  tồn %d%n",
                maSP, tenSP, dinhDangTien(donGia), soLuongTon);
    }
}
