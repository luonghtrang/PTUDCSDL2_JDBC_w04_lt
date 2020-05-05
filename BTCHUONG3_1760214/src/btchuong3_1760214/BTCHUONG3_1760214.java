/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btchuong3_1760214;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author OS
 */
public class BTCHUONG3_1760214 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //1. Đăng ký driver và tạo kết nối đến CSDL
        Driver driver = new org.gjt.mm.mysql.Driver();
        DriverManager.registerDriver(driver);
        
        //2. Tạo kết nối đến CSDL
        String conString = "jdbc:mysql://localhost:3306/qldact";
        Properties info = new Properties();
        info.setProperty("characterEncoding", "utf8");
        info.setProperty("user", "root");
        info.setProperty("password", "");
        Connection connection;
        connection = DriverManager.getConnection(conString, info);
        
        //3. Tạo đối tượng Statement để thực hiện thao tác dữ liệu mong muốn
//        Statement statement = connection.createStatement();
//        String sql = "SELECT * FROM NHANVIEN";
        
        //4. Thực hiện truy xuất (đọc / ghi)
//        statement.execute(sql);
//        ResultSet rs = statement.getResultSet();
        
        //5. Xử lý khi trả về
//        while (rs.next()){
//            int manv = rs.getInt("MANV");
//            String ho = rs.getString("HONV");
//            String tenlot = rs.getString("TENLOT");
//            String ten = rs.getString("TENNV");
//            System.out.println(manv+" "+ho+" "+ten);
//        }
//        connection.close();
        
        
        System.out.println("--------------------------------");
        System.out.println("---------------MENU-------------");
        System.out.println("--------------------------------");
        System.out.println("==============CÂU 1=============");
        System.out.println("1. Load bảng Nhân Viên");
        System.out.println("2. Thêm nhân viên");
        System.out.println("3. Xóa nhân viên");
        System.out.println("4. Sửa nhân viên");
        System.out.println("==============CÂU 3=============");
        System.out.println("5. Tìm kiếm nhân viên theo tên");
        System.out.println("6. Tìm kiếm nhân viên theo phòng");
        System.out.println("7. Tìm kiếm nhân viên theo lương");
        System.out.println("==============CÂU 7=============");
        System.out.println("8. Load bảng Phân Công");
        System.out.println("9. Thêm phân công nhân viên tham gia công việc");
        System.out.println("10. Xóa phân công nhân viên tham gia công việc");
        System.out.println("11. Sửa phân công nhân viên tham gia công việc");
        System.out.println("================================");
        System.out.println("0. THOAT");
        Scanner scan = new Scanner(System.in);
        int nChucNang = -1;
        
        while (nChucNang != 0) {
            System.out.print("Vui long chon chuc nang 0-11: ");
            nChucNang = Integer.parseInt(scan.nextLine());
            switch (nChucNang){
                case 1:
                {
                    System.out.println("Danh sách Nhân Viên:");
                    Statement statement = connection.createStatement();
                    String sql = "SELECT * FROM NHANVIEN";

                    statement.execute(sql);
                    ResultSet rs = statement.getResultSet();

                    while (rs.next()){
                        String manv = rs.getString("MANV");
                        String ho = rs.getString("HONV");
                        String tenlot = rs.getString("TENLOT");
                        String ten = rs.getString("TENNV");
                        System.out.println(manv+" "+ho+" "+tenlot+" "+ten);
                    }
                    break;
                }

                case 2:{
                    System.out.println("Bạn vừa chọn chức năng THÊM nhân viên"); 
                    Statement statement = connection.createStatement();
                    String sql = "insert into NHANVIEN(manv, honv, tenlot, tennv) values(?,?,?,?)";
                    PreparedStatement preStatement = connection.prepareStatement(sql);
                    System.out.print("Mời bạn nhập mã nhân viên: "); 
                    String manhanvien = scan.nextLine();
                    String sqls = "SELECT * FROM NHANVIEN";

                    statement.execute(sqls);
                    ResultSet rs = statement.getResultSet();
                    while(rs.next()){
                        do{
                            if(manhanvien == rs.getString("MANV")){
                                System.out.print("Mời bạn nhập lại mã nhân viên khác "+manhanvien+": ");
                                manhanvien = scan.nextLine();
                            }
                        }while(manhanvien == rs.getString("MANV"));
                    }

                    System.out.print("Mời bạn nhập họ nhân viên: ");
                    String honhanvien = scan.nextLine();
                    System.out.print("Mời bạn nhập tên lót của nhân viên: ");
                    String tenlotnhanvien = scan.nextLine();
                    System.out.print("Mời bạn nhập tên nhân viên: ");
                    String tennhanvien = scan.nextLine();

                    preStatement.setString(1, manhanvien);
                    preStatement.setString(2, honhanvien);
                    preStatement.setString(3, tenlotnhanvien);
                    preStatement.setString(4, tennhanvien);
                    int row_effect = preStatement.executeUpdate();
                    System.out.println("Query OK "+row_effect);

                    break;
                }
                case 3:{
                    System.out.println("Bạn vừa chọn chức năng XÓA nhân viên"); 
                    Statement statement = connection.createStatement();
                    System.out.print("Bạn nhập mã nhân viên cần xóa: ");
                    String manhanvien = scan.nextLine();
                    String sql = "delete from NHANVIEN where MANV = "+manhanvien;
                    int n = statement.executeUpdate(sql);

                    if (n >= 1){
                        System.out.println("Xóa thành công !!!");
                    } 
                    else {
                        System.out.println("Lỗi!!!");
                    }

                    break;
                }
                case 4:{
                    System.out.println("Bạn vừa chọn chức năng sửa nhân viên"); 
                    Statement statement = connection.createStatement();
                    System.out.print("Bạn nhập mã nhân viên muốn sửa thông tin: ");
                    String manhanvien = scan.nextLine();
                    System.out.print("Mời bạn nhập họ nhân viên: ");
                    String honhanvien = scan.nextLine();
                    System.out.print("Mời bạn nhập tên lót của nhân viên: ");
                    String tenlotnhanvien = scan.nextLine();
                    System.out.print("Mời bạn nhập tên nhân viên: ");
                    String tennhanvien = scan.nextLine();

                    String sql = "update NHANVIEN set honv = '" + honhanvien + "', tenlot = '" + tenlotnhanvien + "', tennv = '" + tennhanvien + "' where manv = '" + manhanvien+"'";
    //                String sql = "update NHANVIEN set honv = 'Nguyen', tenlot = Ngoc, tennv = Quang where manv = " + manhanvien;
                    int n = statement.executeUpdate(sql);
                    ResultSet rs = statement.getResultSet();

                    statement.getGeneratedKeys();

                    if(rs != null){
                        while(rs.next()){
                            if(manhanvien == rs.getString("MANV")){
                                manhanvien = rs.getString("MANV");
                                honhanvien = rs.getString("HONV");
                                tenlotnhanvien = rs.getString("TENLOT");
                                tennhanvien = rs.getString("TENNV");

                                System.out.println(manhanvien+" "+honhanvien+" "+tenlotnhanvien+" "+tennhanvien);
                            }
                        }
                    }

                    if (n == 1){
                        System.out.println("Update thành công !!!");
                    } else {
                        System.out.println("Lỗi !!!");
                    }

                    break;
                }
                case 5:{
                    System.out.println("Tìm kiếm nhân viên theo tên:");
                    Statement statement = connection.createStatement();
                    System.out.print("Bạn nhập TÊN nhân viên cần tìm: ");
                    String tennhanvien = scan.nextLine();

                    String sql = "SELECT * FROM NHANVIEN WHERE TENNV = '" + tennhanvien +"'";

                    statement.execute(sql);
                    ResultSet rs = statement.getResultSet();

                    while (rs.next()){
                        String manv = rs.getString("MANV");
                        String ho = rs.getString("HONV");
                        String tenlot = rs.getString("TENLOT");
                        String ten = rs.getString("TENNV");
                        System.out.println(manv+" "+ho+" "+tenlot+" "+ten);
                    }


                    break;
                }
                case 6:{
                    System.out.println("Tìm kiếm nhân viên theo phòng:");
                    Statement statement = connection.createStatement();
                    System.out.print("Bạn nhập PHÒNG nhân viên cần tìm: ");
                    String phong = scan.nextLine();

                    String sql = "SELECT * FROM NHANVIEN WHERE PHG = '" + phong +"'";

                    statement.execute(sql);
                    ResultSet rs = statement.getResultSet();

                    while (rs.next()){
                        String manv = rs.getString("MANV");
                        String ho = rs.getString("HONV");
                        String tenlot = rs.getString("TENLOT");
                        String ten = rs.getString("TENNV");
                        System.out.println(manv+" "+ho+" "+tenlot+" "+ten);
                    }



                    break;
                }
                case 7:{
                    System.out.println("Tìm kiếm nhân viên theo lương:");
                    Statement statement = connection.createStatement();
                    System.out.print("Bạn nhập LƯƠNG tìm nhân viên: ");
                    String luong = scan.nextLine();

                    String sql = "SELECT * FROM NHANVIEN WHERE LUONG = '" + luong +"'";

                    statement.execute(sql);
                    ResultSet rs = statement.getResultSet();

                    while (rs.next()){
                        String manv = rs.getString("MANV");
                        String ho = rs.getString("HONV");
                        String tenlot = rs.getString("TENLOT");
                        String ten = rs.getString("TENNV");
                        System.out.println(manv+" "+ho+" "+tenlot+" "+ten);
                    }
                    break;
                }
                case 8:{
                    System.out.println("Danh sách Phân Công:");
                    Statement statement = connection.createStatement();
                    String sql = "SELECT * FROM PHANCONG";

                    statement.execute(sql);
                    ResultSet rs = statement.getResultSet();

                    while (rs.next()){
                        String manv = rs.getString("MA_NVIEN");
                        String mada = rs.getString("MADA");
                        int stt = rs.getInt("STT");
                        Date thoigian = rs.getDate("THOIGIAN");
                        System.out.println(manv+" "+mada+" "+stt+" "+thoigian);
                    }
                    break;
                }
                case 9:{
                    System.out.println("Bạn vừa chọn chức năng THÊM phân công của nhân viên"); 
                    Statement statement = connection.createStatement();
                    String sql = "insert into PHANCONG  (ma_nvien, mada, stt, thoigian) values(?,?,?,?)";
                    PreparedStatement preStatement = connection.prepareStatement(sql);
                    System.out.print("Mời bạn nhập mã nhân viên: "); 
                    String manhanvien = scan.nextLine();

                    System.out.print("Mời bạn nhập mã đề án: ");
                    String madean = scan.nextLine();
                    System.out.print("Mời bạn nhập STT: ");
                    int SoTT = Integer.parseInt(scan.nextLine());
                    System.out.print("Mời bạn nhập thời gian: ");
                    String thoigian = scan.nextLine();

                    preStatement.setString(1, manhanvien);
                    preStatement.setString(2, madean);
                    preStatement.setInt(3, SoTT);
                    preStatement.setString(4, thoigian);
                    int row_effect = preStatement.executeUpdate();
                    System.out.println("Query OK "+row_effect);
                    break;
                }
                case 10:{

                    System.out.println("Bạn vừa chọn chức năng XÓA phân công cho nhân viên"); 
                    Statement statement = connection.createStatement();
                    System.out.print("Bạn nhập mã nhân viên cần xóa: ");
                    String manhanvien = scan.nextLine();
                    String sql = "delete from PHANCONG where MA_NVIEN = "+manhanvien;
                    int n = statement.executeUpdate(sql);

                    if (n >= 1){
                        System.out.println("Xóa thành công !!!");
                    } 
                    else {
                        System.out.println("Lỗi!!!");
                    }

                    break;
                }
                case 11:{

                    System.out.println("Bạn vừa chọn chức năng SỬA phân công nhân viên"); 
                    Statement statement = connection.createStatement();
                    System.out.print("Bạn nhập SỐ THỨ TỰ CÔNG VIỆC muốn sửa thông tin: ");
                    int SoTT = Integer.parseInt(scan.nextLine());
                    System.out.print("Mời bạn Mã Đề Án: ");
                    String madean = scan.nextLine();
                    System.out.print("Mời bạn nhập mã nhân viên: ");
                    String manhanvien = scan.nextLine();
                    System.out.print("Mời bạn nhập thời gian: ");
                    String tgian = scan.nextLine();

                    String sql = "update PHANCONG set MADA = '" + madean + "', MA_NVIEN = '" + manhanvien + "', THOIGIAN = '" + tgian + "' where STT = '" + SoTT +"'";

                    int n = statement.executeUpdate(sql);
                    ResultSet rs = statement.getResultSet();

                    statement.getGeneratedKeys();

                    if(rs != null){
                        while(rs.next()){
                            if(SoTT == rs.getInt("STT")){
                                manhanvien = rs.getString("MA_NVIEN");
                                madean = rs.getString("madean");
                                SoTT = rs.getInt("STT");
                                tgian = rs.getString("tgian");

                                System.out.println(manhanvien+" "+madean+" "+SoTT+" "+tgian);
                            }
                        }
                    }

                    if (n == 1){
                        System.out.println("Update thành công !!!");
                    } else {
                        System.out.println("Lỗi !!!");
                    }

                    break;
                }
                case 0:
                    connection.close();
                    System.out.println("BAN VUA CHON THOAT !!! ");
                    break;

                default: System.out.println("Mời bạn chọn lại từ 0->11!");
            }
            

        }
        
        
    }
    
}
