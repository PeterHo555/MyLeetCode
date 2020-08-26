import java.util.ArrayList;
import java.util.List;

public class Test93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        doRestore(0, tempAddress, addresses, s);
        return addresses;
    }

    private void doRestore(int k, StringBuilder tempAddress, List<String> addresses, String s) {
        //判断是否已经存了三位ip或剩余的s是否为0
        if (k == 4 || s.length() == 0) {
            //ip末尾
            if (k == 4 && s.length() == 0) {
                addresses.add(tempAddress.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            // 非0位存在第一位为0字符为非法ip
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            //取出后i位字符串
            String part = s.substring(0, i + 1);
            //转为整形判断是否小于等于255，为合法IP地址
            if (Integer.valueOf(part) <= 255) {
                if (tempAddress.length() != 0) {
                    part = "." + part;
                }
                tempAddress.append(part); // 添加
                doRestore(k + 1, tempAddress, addresses, s.substring(i + 1)); //
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length()); // 删除
                System.out.println(part);
            }
        }
    }

//    public List<String> restoreIpAddresses(String s) {
//        List<String> r = new ArrayList<>();
//        if(s.length() > 12) return r;
//        for(int i = 1; i < s.length() && i <= 3; ++i){
//            for(int j = i; j < s.length() && j <= i + 3; ++j){
//                for(int k = j; k < s.length() && k <= j + 3; ++k){
//                    String s1 = s.substring(0, i);
//                    String s2 = s.substring(i, j);
//                    String s3 = s.substring(j, k);
//                    String s4 = s.substring(k);
//                    if(f(s1)&&f(s2)&&f(s3)&&f(s4)){
//                        StringBuilder sb = new StringBuilder();
//                        sb.append(s1); sb.append(".");
//                        sb.append(s2); sb.append(".");
//                        sb.append(s3); sb.append(".");
//                        sb.append(s4);
//                        r.add(sb.toString());
//                    }
//                }
//            }
//        }
//        return r;
//    }
//
//    boolean f(String s){
//        if(s.length() == 0) return false;
//        if(s.length() == 1) return true;
//        if(s.length() > 3) return false;
//        if(s.charAt(0) == '0') return false;
//        if(Integer.parseInt(s) <= 255) return true;
//        return false;
//    }
}
