
/**
 * Lớp DonHang: một đơn hàng gồm tên khách, MỘT loại sản phẩm và số lượng mua.
 */
public class DonHang {
    // ===== Thuộc tính (private) =====
    private String tenKhach;
    private SanPham sanPham;
    private int soLuong;

    // Hằng số nghiệp vụ: từ 5 cái trở lên giảm 10%
    private static final int SO_LUONG_GIAM_GIA = 5;
    private static final double TI_LE_GIAM = 0.10;

    // ===== Constructor =====
    public DonHang(String tenKhach, SanPham sanPham, int soLuong) {
        this.tenKhach = tenKhach;
        this.sanPham = sanPham;
        this.soLuong = (soLuong < 1) ? 1 : soLuong;
    }

    // ===== Getter =====
    public String getTenKhach() {
        return tenKhach;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // ===== Phương thức =====

    // Đơn này có được giảm giá không?
    private boolean duocGiamGia() {
        return soLuong >= SO_LUONG_GIAM_GIA;
    }

    // Thành tiền = đơn giá × số lượng; từ 5 cái trở lên giảm 10%
    public double tinhThanhTien() {
        double thanhTien = sanPham.getDonGia() * soLuong;
        if (duocGiamGia()) {
            thanhTien = thanhTien * (1 - TI_LE_GIAM);
        }
        return thanhTien;
    }

    public static void inTieuDe() {
        System.out.printf("%-7s%-17s%-4s%s%n", "Khách", "Sản phẩm", "SL", "Thành tiền");
    }

    public void inDonHang() {
        System.out.printf("%-7s%-17s%-4d%10s%n",
                tenKhach, sanPham.getTenSP(), soLuong,
                SanPham.dinhDangTien(tinhThanhTien()));
        if (duocGiamGia()) {
            System.out.printf("%-7s(đã giảm 10%%)%n", "");
        }
    }
}
