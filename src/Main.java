import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    static class NumeroOculto {
        private int numero;
        private AtomicBoolean juegoTerminado;

        public NumeroOculto() {
            Random rand = new Random();
            this.numero = rand.nextInt(101);
            this.juegoTerminado = new AtomicBoolean(false);
        }

        public int propuestaNumero(int num) {
            if (juegoTerminado.get()) {
                return -1;
            } else if (num == numero) {
                juegoTerminado.set(true);
                return 1;
            } else {
                return 0;
            }
        }
    }

    static class Adivinador extends Thread {
        private NumeroOculto numeroOculto;
        private String nombre;

        public Adivinador(NumeroOculto numeroOculto, String nombre) {
            this.numeroOculto = numeroOculto;
            this.nombre = nombre;
        }

        @Override
        public void run() {
            Random rand = new Random();

            while (true) {
                int propuesta = rand.nextInt(101);
                int resultado = numeroOculto.propuestaNumero(propuesta);

                if (resultado == -1) {
                    System.out.println(nombre + ": El juego finalizo");
                    break;
                } else if (resultado == 1) {
                    System.out.println(nombre + ": Número adivinado, era " + propuesta);
                    break;
                } else {
                    System.out.println(nombre + ": No he acertado. Mi propuesta fue " + propuesta);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



}
