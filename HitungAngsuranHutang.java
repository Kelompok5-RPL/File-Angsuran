import java.util.*;
import java.text.DecimalFormat;
import java.io.*;

//* @author Kelompok 5
//* @version 1.0
//* @since 01-12-2020

public class HitungAngsuranHutang{
	public static void main(String[] args) {
		
		//untuk menginputkan suatu huruf atau bilangan
		Scanner in = new Scanner(System.in);
		//membuat dua angka di belakang koma
  		DecimalFormat digit = new DecimalFormat("0.00");
		int lama = 0;
		String nama;
		String namaSaudara;
		String nik, tglLahir, alamat, kel, kec, status, pekerjaan, alamatSaudara, debit, tanya, cekDebit;
		String tanyalagi = "";
		// double hutang, bunga, bunga1, angsur, sisa, bayar;
		double hutang = 0;
		double bunga = 0;
		double bunga1 = 0;
		double angsur = 0;
		double sisa = 0;
		double bayar = 0;
		double total = 0;
		double totbunga = 0;
		boolean checking_digit = false;
		boolean next_step = false;

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
	  		do{
		  		System.out.print("NIK               = ");
	  			nik = in.next();
	  			in.nextLine();
	  			checking_digit = nik.length() < 16;
	  			if (!nik.matches("[0-9]+")) {
	  				next_step = true;
	  				System.out.println("Inputan Invalid - Harus Angka");
	  			}else if (checking_digit){
	  				next_step = true;
	  				System.out.println("Inputan Invalid - Harus 16 Digit Angka");

	  			}else{
	  			next_step = false;
		  		String tampung = nik;
		  		}
	  		}while(next_step);
	  		
	  		do{
		  		System.out.print("Nama              = ");
		  		nama = in.nextLine();
	  			if (!nama.matches("[A-Za-z\\s]+")) {
	  				System.out.println("Inputan harus sesuai");
	  			}
		  		String tampung = nama;
	  		}while(!nama.matches("[A-Za-z\\s]+"));
	  		do{
		  		System.out.print("Tempat/tgl Lahir  = ");
	  			tglLahir = in.nextLine();
	  			if (!tglLahir.matches("[A-Za-z0-9\\s-,]+")) {
	  				System.out.println("Inputan harus sesuai");
	  			}
		  		String tampung = tglLahir;
	  		}while(!tglLahir.matches("[A-Za-z0-9\\s-,]+"));
	  		do{
		  		System.out.print("Alamat            = ");
	  			alamat = in.nextLine();
	  			if (!alamat.matches("[A-Za-z0-9\\s.,/]+")) {
	  				System.out.println("Inputan harus sesuai");
	  			}
		  		String tampung = alamat;
	  		}while(!alamat.matches("[A-Za-z0-9\\s.,/]+"));
	  		
	  		do{
		  		System.out.print("Kelurahan         = ");
	  			kel = in.nextLine();
	  			if (!kel.matches("[A-Za-z\\s]+")) {
	  				System.out.println("Inputan harus sesuai");
	  			}
		  		String tampung = kel;
	  		}while(!kel.matches("[A-Za-z\\s]+"));
	  		
	  		do{
		  		System.out.print("Kecamatan         = ");
	  			kec = in.nextLine();
	  			if (!kec.matches("[A-Za-z\\s]+")) {
	  				System.out.println("Inputan harus sesuai");
	  			}
		  		String tampung = kec;
	  		}while(!kec.matches("[A-Za-z\\s]+"));
	  		
	  		do{
		  		System.out.print("Status Perkawinan = ");
	  			status = in.nextLine();
	  			if (!status.matches("[A-Za-z\\s]+")) {
	  				System.out.println("Inputan harus sesuai");
	  			}
		  		String tampung = status;
	  		}while(!status.matches("[A-Za-z\\s]+"));
	  		
	  		do{
		  		System.out.print("Pekerjaan         = ");
	  			pekerjaan = in.nextLine();
	  			if (!pekerjaan.matches("[A-Za-z\\s]+")) {
	  				System.out.println("Inputan harus sesuai");
	  			}
		  		String tampung = pekerjaan;
	  		}while(!pekerjaan.matches("[A-Za-z\\s]+"));
	  		
	  		System.out.println();
	  		System.out.println();
	  		System.out.println("DATA PEMINJAMAN");
	  		System.out.println("____________________________________________________________________");

  			System.out.println("Maksimal Peminjaman Rp. 200000000");
  			System.out.print("Besar Pinjaman         = Rp. ");
  			try{
				hutang = in.nextInt();

				if (hutang > 200000000 || hutang <= 0) {
					System.out.println("Maaf Tidak Menerima Besar Pinjaman Tersebut :)");
					Terimakasih();
					break;
				}
	  			System.out.println("Maksimal Lama Angsuran 48 Bulan");
	  			System.out.print("Lama Angsuran (bulan)  = ");
				lama = in.nextInt();
				if (lama > 48 || lama <= 0) {
					System.out.println("Maaf Tidak Menerima Lama Angsuran Tersebut :)");
					Terimakasih();
					break;
				}
			} catch (Exception e){
				System.out.println("\nInput Invalid - Input harus berupa Angka");
				Terimakasih();
  				break;
  			}
			System.out.println();
			System.out.println();
	  		System.out.println("DATA SAUDARA TIDAK SERUMAH");
	  		System.out.println("____________________________________________________________________");
	  		do{
		  		System.out.print("Masukkan Nama Saudara  = ");
	  			namaSaudara = in.next();
	  			in.nextLine();
	  			if (!namaSaudara.matches("[A-Za-z\\s]+")) {
	  				System.out.println("Inputan harus sesuai");
	  			}
		  		String tampung = namaSaudara;
	  		}while(!namaSaudara.matches("[A-Za-z\\s]+"));
	  		
	  		do{
		  		System.out.print("Masukkan Alamat        = ");
	  			alamatSaudara = in.nextLine();
	  			if (!alamatSaudara.matches("[A-Za-z0-9\\s.,/]+")) {
	  				System.out.println("Inputan harus sesuai");
	  			}
		  		String tampung = alamatSaudara;
	  		}while(!alamatSaudara.matches("[A-Za-z0-9\\s.,/]+"));
	  		
	  		System.out.println();
	  		System.out.println();
	  		System.out.println("NOMOR KARTU DEBIT");
	  		System.out.println("____________________________________________________________________");
	  		System.out.println("Hanya Menerima Pembayaran Melalui Debit");
	  		do{
	  			System.out.print("Bayar Dengan Debit (Y/N) = ");
	  			cekDebit = in.nextLine().toUpperCase();
	  			if (!cekDebit.equals("Y") && !cekDebit.equals("N")) {
	  				System.out.println("Masukkan Y/N");
	  			}
	  			String tampung = cekDebit;
	  		}while(!cekDebit.equals("Y") && !cekDebit.equals("N"));
	  		
	  		if(cekDebit.toUpperCase().equals("Y")){
	  			System.out.println("---------------------------------------------");
	  			System.out.println("Nomor Pembayaran PT. YUHU 4637-01-010974-51-1");
	  			System.out.println("---------------------------------------------");
	  			do{
		  			System.out.print("Masukkan Nomor Kartu     = ");
	  				debit = in.nextLine();
	  				if (!debit.matches("[0-9]+")) {
	  					System.out.println("Inputan harus sesuai");
	  				}
		  			String tampung = debit;
	  			}while(!debit.matches("[0-9]+"));
	  			
	  		}
	  		else{
	  			System.out.println("Maaf Kami Hanya Menerima Pembayaran Melalui Debit :)");
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
	   		do{
	  			System.out.print("Apakah Data sudah benar dan setuju (Y/N) : ");
		    	tanya = in.next().toUpperCase();
	  			if (!tanya.equals("Y") && !tanya.equals("N")) {
	  				System.out.println("Masukkan Y/N");
	  			}
	  			String tampung = tanya;
	  		}while(!tanya.equals("Y") && !tanya.equals("N"));
	   		
		    if (tanya.equals("Y")){
		        Terimakasih();
		        break;
		    }
		    else {
		    	do{
		  			System.out.print("Apakah ingin di ulang (Y/N)              : ");
	   				tanyalagi = in.next().toUpperCase();
		  			if (!tanyalagi.equals("Y") && !tanyalagi.equals("N")) {
		  				System.out.println("Masukkan Y/N");
		  			}
		  			String tampung = tanyalagi;
		  		}while(!tanyalagi.equals("Y") && !tanyalagi.equals("N"));
		    	
	   			if (tanyalagi.equals("N")) {
	   				Terimakasih();
	   				break;
	   			}
		    }
  		}while(tanyalagi.equals("Y"));
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