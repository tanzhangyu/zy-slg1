package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import com.zy.common.constant.CMDConstants;
import com.zy.common.message.generate.RequestMessageProtoBuf;
import com.zy.common.message.generate.RequestMessageProtoBuf.GameRequestMsg;
import com.zy.common.message.generate.ResponeMessageProtoBuf.GameResponeMsg;

public class test {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 8888);
			InputStream input = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			while (true) {
				System.out.print("请输入: \t");
				String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
				GameRequestMsg.Builder builder = GameRequestMsg.newBuilder();
				builder.setCmd(CMDConstants.USER_LOGIN);
				RequestMessageProtoBuf.C2G_LoginParms.Builder b = RequestMessageProtoBuf.C2G_LoginParms.newBuilder();
				b.setAccount("15616360820");
				b.setPassword("zhangyu11111");
//				builder.setLogin(b.build());
				out.write(builder.build().toByteArray());
				int lenght = 0;
				while (lenght == 0) {
					lenght = input.available();
				}
				System.out.println(lenght);
				byte[] a = new byte[lenght];
				input.read(a);
				GameResponeMsg gameResponeMsg = GameResponeMsg.parseFrom(a);
				System.out.println(gameResponeMsg.getError());

//				System.out.println("服务器端返回过来的是: " + ret);
//				out.close();
//				input.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}
