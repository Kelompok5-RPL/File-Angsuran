//Kelompok 5 RPL
// Rekayasa Perangkat Lunak
// Hitung Angsuran Hutang

import java.util.*;
import java.text.DecimalFormat;
import java.io.*;

* @author Kelompok 5
* @version 1.0
* @since 01-12-2020

public class HitungAngsuranHutang{
	public static void main(String[] args) {
		
		//untuk menginputkan suatu huruf atau bilangan
		Scanner in = new Scanner(System.in);
		//membuat dua angka di belakang koma
  		DecimalFormat digit = new DecimalFormat("0.00");
		int lama;
		String nama;
		String namaSaudara;
		String nik, tglLahir, alamat, kel, kec, status, pekerjaan, alamatSaudara, debit, tanya, cekDebit;
		String tanyalagi = "";
		double hutang, bunga, bunga1, angsur, sisa, bayar;
		double total = 0;
		double totbunga = 0;

		System.out.println();
  		do{
  			System.out.println("____________________________________________________________________");
  			System.out.println();
			System.out.println("                PROGRAM HITUNG ANGSURAN PEMINJAMAN");
			System.out.println("                            PT. HAYUUUU");
	  		System.out.println("____________________________________________________________________");
	  		System.out.println();
	  		System.out.println();
	  		System.out.println("INPUT DATA SESUAI KTP");
	  		System.out.println("____________________________________________________________________");
	  		System.out.print("NIK               = ");
	  		nik = in.nextLine();
	  		do{
		  		System.out.print("Nama              = ");
		  		nama = in.nextLine();
	  		}while(nama.equals(""));
	  		System.out.print("Tempat/tgl Lahir  = ");
	  		tglLahir = in.nextLine();
	  		System.out.print("Alamat            = ");
	  		alamat = in.nextLine();
	  		System.out.print("Kelurahan         = ");
	  		kel = in.nextLine();
	  		System.out.print("Kecamatan         = ");
	  		kec = in.nextLine();
	  		System.out.print("Status            = ");
	  		status = in.nextLine();
	  		System.out.print("Pekerjaan         = ");
	  		pekerjaan = in.nextLine();
	  		System.out.println();
	  		System.out.println();
	  		System.out.println("DATA PEMINJAMAN");
	  		System.out.println("____________________________________________________________________");
	  		do{
	  			System.out.print("Besar Pinjaman         = Rp. ");
				hutang = in.nextInt();
				if(hutang > 200000000 || hutang <= 0){
					System.out.println("Maksimal Peminjaman Rp. 200000000");
				}
	  		}while(hutang > 200000000 || hutang <= 0);
	  		do{
	  			System.out.print("Lama Angsuran (bulan)  = ");
				lama = in.nextInt();
	  		}while(lama > 48 || lama <= 0);
			System.out.println();
			System.out.println();
	  		System.out.println("DATA SAUDARA TIDAK SERUMAH");
	  		System.out.println("____________________________________________________________________");
	  		System.out.print("Masukkan Nama Saudara  = ");
	  		namaSaudara = in.nextLine();
	  		in.nextLine();
	  		System.out.print("Masukkan Alamat        = ");
	  		alamatSaudara = in.nextLine();
	  		System.out.println();
	  		System.out.println();
	  		System.out.println("NOMOR KARTU DEBIT");
	  		System.out.println("____________________________________________________________________");
	  		System.out.print("Bayar Dengan Debit (Y/N) = ");
	  		cekDebit = in.nextLine();
	  		if(cekDebit.toUpperCase().equals("Y")){
	  			System.out.println("---------------------------------------------");
	  			System.out.println("Nomor Pembayaran PT. YUHU 4637-01-010974-51-1");
	  			System.out.println("---------------------------------------------");
	  			System.out.print("Masukkan Nomor Kartu     = ");
	  			debit = in.nextLine();
	  		}
	  		else{
	  			System.out.println("Maaf Kami Hanya Menerima Melalui Debit :)");
	  			Terimakasih();
	  			break;
	  		}
	  		System.out.println();
	  		System.out.println();

	  		for (int i = 1; i <= lama; i++ ) {
				angsur = hutang / lama;
				sisa = hutang - (angsur * i);
				bunga = hutang / (sisa + angsur);
				bunga1 = (bunga * hutang) / 100;
				bayar = bunga1 + angsur;
				total += bayar;
				totbunga += bunga1;
			}

			System.out.println("____________________________________________________________________");
			System.out.println("\t\tSURAT PERJANJIAN PEMINJAMAN UANG");
			System.out.println();
			System.out.println("Dengan ini kami :");
			System.out.println("Nama     = " + nama);
			System.out.println("Alamat   = " + alamat);
			System.out.println("Bertindah untuk dan atas nama diri sendiri dan untuk selanjutnya.");
			System.out.println();
			System.out.println("Dengan ini menyatakan, bahwa saya telah dengan sah dan benar\nmempunyai utang uang karena peminjaman kepada PT. YUHUUU.\nSebesar Rp. " + digit.format(total) +".");
			System.out.println("Saya mengakui telah menerima jumlah uang tersebut secara lengkap\ndari pihak PT. YUHUUU, sehingga Surat Perjanjian ini diakui oleh\nkedua belah pihakdan berlaku sebagai tanda penerimaan yang sah.");
			System.out.println();
			System.out.println("\t\t\tPEMBAYARAN");
			System.out.println();
			System.out.println("Saya berjanji akan membayar hutang uang paling lambat setiap\ntanggal 1 dengan denda keterlambatan Rp. 5000 per harinya.");
			System.out.println("Akan membayar hutang uang setiap bulannya sebesar:");

			angsur = 0;
			sisa = 0;
			bunga = 0;
			bunga1 = 0;
			bayar = 0;
			total = 0;
			totbunga = 0;

			for (int i = 1; i <= lama; i++ ) {
				angsur = hutang / lama;
				sisa = hutang - (angsur * i);
				bunga = hutang / (sisa + angsur);
				bunga1 = (bunga * hutang) / 100;
				bayar = bunga1 + angsur;
				total += bayar;
				totbunga += bunga1;

				System.out.println();
				System.out.println("BULAN KE - " + i);
	   			System.out.println("____________________________________________________________________");
	   			System.out.println("Suku bunga         = " + digit.format(bunga) + "%");
	   			System.out.println("Besar bunga        = Rp. " + digit.format(bunga1));
	   			System.out.println("Bayar              = Rp. " + digit.format(bayar));
	   			System.out.println("Sisa Pinjaman      = Rp. " + digit.format(sisa));
	   			System.out.println("____________________________________________________________________");
			}

			System.out.println();
	   		System.out.println("____________________________________________________________________");
	   		System.out.println("Pinjaman awal          = Rp. " + digit.format(hutang));
	   		System.out.println("Total bunga            = Rp. " + digit.format(totbunga));
	   		System.out.println("Total (termasuk bunga) = Rp. " + digit.format(total));
	   		System.out.println("____________________________________________________________________");
	   		System.out.println();

	   		//Looping
		    System.out.print("Apakah Data sudah benar dan setuju (Y/N) : ");
		    tanya = in.next();

		    if (tanya.equalsIgnoreCase("y")){
		        Terimakasih();
		        break;
		    }
		    else {
		    	System.out.print("Apakah ingin di ulang (Y/N)              : ");
	   			tanyalagi = in.next();
	   			if (tanyalagi.equalsIgnoreCase("T")) {
	   				Terimakasih();
	   			}
		    }
  		}while(!tanyalagi.toUpperCase().equals("T"));
	}
	private static void Terimakasih(){  
	    System.out.println();
	    System.out.println("____________________________________________________________________");
	    System.out.println();
	    System.out.println("                           TERIMAKASIH :)");
	    System.out.println("                            PT. HAYUUUU");
	    System.out.println("____________________________________________________________________");
	}
}