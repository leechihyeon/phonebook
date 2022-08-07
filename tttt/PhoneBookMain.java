package phonebook220526;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PhoneBookMain {

	public static void main(String[] args) throws IOException {
//		PhoneBook pb=new PhoneBook("홍길동", "010-1111-1111", "특이사항없음");
//		System.out.println(pb.toString());

		/*PhoneBook pb[]=new PhoneBook[10];

		for(int i=0;i<10;i++) {
			pb[i]=new PhoneBook("홍길동","010-1111-1111","특이사항없음");
		}

		for(int i=0;i<10;i++) {
			System.out.println(i+" : "+pb[i]);
		}*/
		// 객체를 만들기 위한 10개의 공간을 확보
		PhoneBook pb[]=new PhoneBook[10];
		// 파일데이터를 읽어오는 작업, 코드와 데이터는 분리하여 관리한다.
		File f1=new File("phonebook.txt");
		FileReader f2=new FileReader(f1);
		BufferedReader f3=new BufferedReader(f2);
		String imsi=null;
		int i=0;
		// 파일로부터 데이터를 읽어온 후
		// 문자열을 다시 스페이스로 분리하여 배열에 넣고
		// 배열의 값을 객체를 생성하는데 사용
		while((imsi=f3.readLine())!=null) {
			String arr[]=imsi.split(" ");
			pb[i]=new PhoneBook(arr[0],arr[1],arr[2]);
			i++;
		}
		
		// 입력된 값을 확인
		for(int j=0; j<i;j++) {
			System.out.println(pb[j]);
		}
		
		// 임의적으로 메모리에 객체를 한개 입력함
		pb[i]=new PhoneBook("하길동","010-5555-5555","none");
		i++;
		
		// test
		// phonebook.txt에 쓰기를 하려면 기존 연결되어 있는 상태를 닫아줘야 된다.
		f3.close();
		f2.close();
		FileWriter f4=new FileWriter(f1);
		// 한줄 단위로 쓴다.
		BufferedWriter f5=new BufferedWriter(f4);
		
		// 메모리에서 파일에 쓰는 작업을 진행
		String str="";
		for(int j=0;j<i;j++) {
			str=pb[j].name+" "+pb[j].tel+" "+pb[j].memo+"\n";
			System.out.println("write  : "+str);
			f5.write(str);
			f5.flush();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}