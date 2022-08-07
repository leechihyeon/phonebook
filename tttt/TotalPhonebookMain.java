package tttt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TotalPhonebookMain {

	public static void main(String[] args) throws IOException {
		PhoneBook[] pb = new PhoneBook[100]; // 저장할 공간 100곳 확보
		Scanner sc = new Scanner(System.in);
		int index = 0; // 저장할 위치 초기값
		String search, name, tel, memo = null;
//		screenclear();
		String fileName=null;
		String dataDirectory="C:\\Users\\dlclg\\eclipse-workspace\\JAVA";
		File dir=new File(dataDirectory);
		dir.list();
		String[] filenames=dir.list();
		int q=0;
		System.out.println("< txt 파일 >");
		String filenameresult=null;
		for(String filename:filenames) {
			if(filename.substring(filename.indexOf(".")+1).equals("txt")) {
				q++;
				System.out.println(q+"."+filename);
				filenameresult=q+","+filename;
			}
			
		}
		// 파일로부터 데이터를 읽어와 객체를 메모리에 로드
		/* ***********파일업로드***********/
		System.out.println("불러올 파일명을 입력하세요           ※.txt 생략※\n 파일명 : ");
		String filename[]=new String[10];
		fileName=sc.next();
		
		File f1=new File(fileName);
		if(!f1.exists()) {
			System.out.println(fileName+" 파일이 존재하지 않습니다.");
			while(!f1.exists()) {
				System.out.println("불러올 파일명을 입력하세요           ※.txt 생략※\n 파일명 : ");
				fileName=sc.next()+".txt";
				f1=new File(fileName);
			}
		}
		FileReader f2=new FileReader(f1);
		BufferedReader f3=new BufferedReader(f2);
		String imsi=null;
		// 파일로부터 데이터를 읽어온 후
		// 문자열을 다시 스페이스로 분리하여 배열에 넣고
		// 배열의 값을 객체를 생성하는데 사용
		while((imsi=f3.readLine())!=null) {
			String arr[]=imsi.split(" ");
			pb[index]=new PhoneBook(arr[0],arr[1],arr[2]);
			index++;
		}
		f3.close();
		f2.close();
		/* ***********파일업로드 종료***********/

		while (true) {
			menu();
			int num = sc.nextInt();

			switch (num) {
			case 1: // 연락처 추가
				System.out.print("이름 : ");
				name = sc.next();
				
				System.out.print("전화번호 : ");
				tel = sc.next();
				
				System.out.print("메모 : ");
				memo = sc.next();

				pb[index++] = new PhoneBook(name, tel, memo);
				System.in.read();
				break;

			case 2: // 배열이 null이 아니면 리스트 출력
				for (int i = 0; i < index; i++) {
					if (pb[i]!=null) {
						 // System.out.println(pb[i].toString());
						pb[i].view();
					}
				}
				System.in.read();
				break;

			case 3: // 검색할 이름 검색
				System.out.println("검색할 이름을 입력하세요.");
				search = sc.next();
				for (int i = 0; i < index; i++) {
					if (search.equals(pb[i].name)) {
						// System.out.println(pb[i].toString());
						pb[i].view();
					}

					else if (i == index - 1) {
						System.out.println("검색할 이름이 없습니다.");
					}
				}
				System.in.read();
				break;

			case 4:
				// 수정은 먼저 데이터를 찾고 (이름을 검색하여 index를 찾는다),
				// 수정할 데이터를 입력받고
				// 수정할 데이터를 객체에 다시 저장
				System.out.println("검색할 이름을 입력하세요");
				search = sc.next();
				for (int i = 0; i < index; i++) {
					if (search.equals(pb[i].name)) {
						System.out.println("수정할 이름을 입력하세요");
						name = sc.next();

						System.out.println("전화번호를 입력하세요 ");
						tel = sc.next();

						System.out.println("메모를 입력하세요 : ");
						memo = sc.next();

						pb[i].update(name, tel, memo);
						break;
					}

					else if (i == index - 1) {
						System.out.println("검색할 이름이 없습니다.");
					}
				}
				break;

			case 5:
				System.out.println("삭제할 이름을 입력하세요");
				search = sc.next();
				for (int i = 0; i < index; i++) {
					if (search.equals(pb[i].name)) {
						System.out.println(pb[i].name + "님의 정보를 삭제하겠습니까?");
						System.out.println("1번 삭제 | 2번 취소");
						int delete = sc.nextInt();
						if (delete == 1) {
							pb[i].delete();
						} else if (delete == 2) {
							System.out.println("취소되었습니다.");
						}
						break;
					} 
					if(i==index-1){
						System.out.println("검색한 결과가 없습니다.");
					}
				}
				break;
				
			case 6: // 데이터 불러오기
				System.out.println("< txt 파일 >");	
				/*for(String filename:filenames) {
					if(filename.substring(filename.indexOf(".")+1).equals("txt")) {
						System.out.println(filename);	
					}
					
				}*/
				System.out.println("불러올 파일명을 입력하세요           ※.txt 생략※\n 파일명 : ");
				fileName=sc.next()+".txt";
				f1=new File(fileName);
				if(!f1.exists()) {
					while(!f1.exists()) {
						System.out.println("불러올 파일명을 입력하세요           ※.txt 생략※\n 파일명 : ");
						fileName=sc.next()+".txt";
						f1=new File(fileName);
					}
				}
				f2=new FileReader(f1);
				f3=new BufferedReader(f2);
				imsi=null;
				index=0;
				// pb[100]개의 객체배열을 null값으로 초기화를 시켜준다.
				for(int k=0;k<pb.length;k++) {
					pb[k]=null;
				}
				while((imsi=f3.readLine())!=null) {
					String arr[]=imsi.split(" ");
					pb[index]=new PhoneBook(arr[0],arr[1],arr[2]);
					index++;
				}
				f3.close();
				f2.close();
				break;
				
			case 7: // 데이터 저장하기
				FileWriter f4=new FileWriter(f1);
				// 한줄 단위로 쓴다.
				BufferedWriter f5=new BufferedWriter(f4);
				
				// 메모리에서 파일에 쓰는 작업을 진행
				String str="";
				for(int j=0;j<index;j++) {
					if(!pb[j].name.equals("")) {
						if(j==index-1) { // 마지막 문장은 엔터를 누르지 마라~라는 코드
							str=pb[j].name+" "+pb[j].tel+" "+pb[j].memo;
						}else {
							str=pb[j].name+" "+pb[j].tel+" "+pb[j].memo+"\n";
						}
						System.out.println("write  : "+str);
						f5.write(str);
						f5.flush();	
					}
					
				}
				f5.close();
				f4.close();
				break;

			case 0:
				System.out.println("종료되었습니다.");
				System.exit(0); break;
			}
		}
	}

	static void screenclear() {
		for (int i = 0; i < 80; i++) {
			System.out.println("");
		}
	}

	static void menu() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("   1.추가    2. 리스트    3. 검색    4. 수정    5. 삭제    6.데이터 불러오기    7. 데이터 저장    0. 종료   ");
		System.out.println("--------------------------------------------------------------------");
	}
}
