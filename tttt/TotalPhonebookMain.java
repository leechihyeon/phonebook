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
		PhoneBook[] pb = new PhoneBook[100]; // ������ ���� 100�� Ȯ��
		Scanner sc = new Scanner(System.in);
		int index = 0; // ������ ��ġ �ʱⰪ
		String search, name, tel, memo = null;
//		screenclear();
		String fileName=null;
		String dataDirectory="C:\\Users\\dlclg\\eclipse-workspace\\JAVA";
		File dir=new File(dataDirectory);
		dir.list();
		String[] filenames=dir.list();
		int q=0;
		System.out.println("< txt ���� >");
		String filenameresult=null;
		for(String filename:filenames) {
			if(filename.substring(filename.indexOf(".")+1).equals("txt")) {
				q++;
				System.out.println(q+"."+filename);
				filenameresult=q+","+filename;
			}
			
		}
		// ���Ϸκ��� �����͸� �о�� ��ü�� �޸𸮿� �ε�
		/* ***********���Ͼ��ε�***********/
		System.out.println("�ҷ��� ���ϸ��� �Է��ϼ���           ��.txt ������\n ���ϸ� : ");
		String filename[]=new String[10];
		fileName=sc.next();
		
		File f1=new File(fileName);
		if(!f1.exists()) {
			System.out.println(fileName+" ������ �������� �ʽ��ϴ�.");
			while(!f1.exists()) {
				System.out.println("�ҷ��� ���ϸ��� �Է��ϼ���           ��.txt ������\n ���ϸ� : ");
				fileName=sc.next()+".txt";
				f1=new File(fileName);
			}
		}
		FileReader f2=new FileReader(f1);
		BufferedReader f3=new BufferedReader(f2);
		String imsi=null;
		// ���Ϸκ��� �����͸� �о�� ��
		// ���ڿ��� �ٽ� �����̽��� �и��Ͽ� �迭�� �ְ�
		// �迭�� ���� ��ü�� �����ϴµ� ���
		while((imsi=f3.readLine())!=null) {
			String arr[]=imsi.split(" ");
			pb[index]=new PhoneBook(arr[0],arr[1],arr[2]);
			index++;
		}
		f3.close();
		f2.close();
		/* ***********���Ͼ��ε� ����***********/

		while (true) {
			menu();
			int num = sc.nextInt();

			switch (num) {
			case 1: // ����ó �߰�
				System.out.print("�̸� : ");
				name = sc.next();
				
				System.out.print("��ȭ��ȣ : ");
				tel = sc.next();
				
				System.out.print("�޸� : ");
				memo = sc.next();

				pb[index++] = new PhoneBook(name, tel, memo);
				System.in.read();
				break;

			case 2: // �迭�� null�� �ƴϸ� ����Ʈ ���
				for (int i = 0; i < index; i++) {
					if (pb[i]!=null) {
						 // System.out.println(pb[i].toString());
						pb[i].view();
					}
				}
				System.in.read();
				break;

			case 3: // �˻��� �̸� �˻�
				System.out.println("�˻��� �̸��� �Է��ϼ���.");
				search = sc.next();
				for (int i = 0; i < index; i++) {
					if (search.equals(pb[i].name)) {
						// System.out.println(pb[i].toString());
						pb[i].view();
					}

					else if (i == index - 1) {
						System.out.println("�˻��� �̸��� �����ϴ�.");
					}
				}
				System.in.read();
				break;

			case 4:
				// ������ ���� �����͸� ã�� (�̸��� �˻��Ͽ� index�� ã�´�),
				// ������ �����͸� �Է¹ް�
				// ������ �����͸� ��ü�� �ٽ� ����
				System.out.println("�˻��� �̸��� �Է��ϼ���");
				search = sc.next();
				for (int i = 0; i < index; i++) {
					if (search.equals(pb[i].name)) {
						System.out.println("������ �̸��� �Է��ϼ���");
						name = sc.next();

						System.out.println("��ȭ��ȣ�� �Է��ϼ��� ");
						tel = sc.next();

						System.out.println("�޸� �Է��ϼ��� : ");
						memo = sc.next();

						pb[i].update(name, tel, memo);
						break;
					}

					else if (i == index - 1) {
						System.out.println("�˻��� �̸��� �����ϴ�.");
					}
				}
				break;

			case 5:
				System.out.println("������ �̸��� �Է��ϼ���");
				search = sc.next();
				for (int i = 0; i < index; i++) {
					if (search.equals(pb[i].name)) {
						System.out.println(pb[i].name + "���� ������ �����ϰڽ��ϱ�?");
						System.out.println("1�� ���� | 2�� ���");
						int delete = sc.nextInt();
						if (delete == 1) {
							pb[i].delete();
						} else if (delete == 2) {
							System.out.println("��ҵǾ����ϴ�.");
						}
						break;
					} 
					if(i==index-1){
						System.out.println("�˻��� ����� �����ϴ�.");
					}
				}
				break;
				
			case 6: // ������ �ҷ�����
				System.out.println("< txt ���� >");	
				/*for(String filename:filenames) {
					if(filename.substring(filename.indexOf(".")+1).equals("txt")) {
						System.out.println(filename);	
					}
					
				}*/
				System.out.println("�ҷ��� ���ϸ��� �Է��ϼ���           ��.txt ������\n ���ϸ� : ");
				fileName=sc.next()+".txt";
				f1=new File(fileName);
				if(!f1.exists()) {
					while(!f1.exists()) {
						System.out.println("�ҷ��� ���ϸ��� �Է��ϼ���           ��.txt ������\n ���ϸ� : ");
						fileName=sc.next()+".txt";
						f1=new File(fileName);
					}
				}
				f2=new FileReader(f1);
				f3=new BufferedReader(f2);
				imsi=null;
				index=0;
				// pb[100]���� ��ü�迭�� null������ �ʱ�ȭ�� �����ش�.
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
				
			case 7: // ������ �����ϱ�
				FileWriter f4=new FileWriter(f1);
				// ���� ������ ����.
				BufferedWriter f5=new BufferedWriter(f4);
				
				// �޸𸮿��� ���Ͽ� ���� �۾��� ����
				String str="";
				for(int j=0;j<index;j++) {
					if(!pb[j].name.equals("")) {
						if(j==index-1) { // ������ ������ ���͸� ������ ����~��� �ڵ�
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
				System.out.println("����Ǿ����ϴ�.");
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
		System.out.println("   1.�߰�    2. ����Ʈ    3. �˻�    4. ����    5. ����    6.������ �ҷ�����    7. ������ ����    0. ����   ");
		System.out.println("--------------------------------------------------------------------");
	}
}
