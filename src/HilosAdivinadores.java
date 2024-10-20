public class HilosAdivinadores {
    public static void main(String[] args) {
        Main.NumeroOculto numeroOculto = new Main.NumeroOculto();

        for (int i = 1; i <= 10; i++) {
            Main.Adivinador adivinador = new Main.Adivinador(numeroOculto, "Hilo " + i);
            adivinador.start();
        }
    }
}
