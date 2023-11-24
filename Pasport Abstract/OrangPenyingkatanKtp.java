public class OrangPenyingkatanKtp extends BasedPasport{
    public String BuktiPenyingkatan;
    //Bukti ini biasanya untuk orang yang nama di ktp nya disingkat
    @Override
    public void syaratdaftar(){
        System.out.println("Syarat Daftar untuk KTP yang disingkat");
    }
    @Override
    public void caradaftar(){
        System.out.println("Cara Daftar untuk KTP yang disingkat");
    }
}
