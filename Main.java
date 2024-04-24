import java.util.Scanner;

abstract class FiguraGeometrica {
    abstract double calcularArea();
    abstract double calcularPerimetro();
}

class Circulo extends FiguraGeometrica {
    public double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    double calcularArea() {
        return Math.PI * radio * radio;
    }

    double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

class Rectangulo extends FiguraGeometrica {
    public double base;
    public double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    double calcularArea() {
        return base * altura;
    }

    double calcularPerimetro() {
        return 2 * (base + altura);
    }
}

class Cuadrado extends FiguraGeometrica {
    public double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    double calcularArea() {
        return lado * lado;
    }

    double calcularPerimetro() {
        return 4 * lado;
    }
}

class TrianguloRectangulo extends FiguraGeometrica {
    public double base;
    public double altura;

    public TrianguloRectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    double calcularArea() {
        return 0.5 * base * altura;
    }

    double calcularPerimetro() {
        return base + altura + calcularHipotenusa();
    }

    double calcularHipotenusa() {
        return Math.sqrt(base * base + altura * altura);
    }

    String tipoTriangulo() {
        if (base == altura) {
            return "Equilátero";
        } else if (base == Math.sqrt((altura * altura) / 2)) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creacion del círculo
        System.out.println("Ingrese el radio del círculo en centímetros: ");
        double radioCirculo = scanner.nextDouble();
        Circulo circulo = new Circulo(radioCirculo);

        // Creacion del rectángulo
        System.out.println("Ingrese la base del rectángulo en centímetros: ");
        double baseRectangulo = scanner.nextDouble();
        System.out.println("Ingrese la altura del rectángulo en centímetros: ");
        double alturaRectangulo = scanner.nextDouble();
        Rectangulo rectangulo = new Rectangulo(baseRectangulo, alturaRectangulo);

        // Creacion del cuadrado
        System.out.println("Ingrese la longitud del lado del cuadrado en centímetros: ");
        double ladoCuadrado = scanner.nextDouble();
        Cuadrado cuadrado = new Cuadrado(ladoCuadrado);

        // Creacion del triángulo rectángulo
        System.out.println("Ingrese la base del triángulo rectángulo en centímetros: ");
        double baseTriangulo = scanner.nextDouble();
        System.out.println("Ingrese la altura del triángulo rectángulo en centímetros: ");
        double alturaTriangulo = scanner.nextDouble();
        TrianguloRectangulo triangulo = new TrianguloRectangulo(baseTriangulo, alturaTriangulo);

        // Mostrando resultados
        System.out.println("\nResultados:");
        System.out.println("Área del círculo: " + circulo.calcularArea() + " cm^2");
        System.out.println("Perímetro del círculo: " + circulo.calcularPerimetro() + " cm");
        System.out.println("\nÁrea del rectángulo: " + rectangulo.calcularArea() + " cm^2");
        System.out.println("Perímetro del rectángulo: " + rectangulo.calcularPerimetro() + " cm");
        System.out.println("\nÁrea del cuadrado: " + cuadrado.calcularArea() + " cm^2");
        System.out.println("Perímetro del cuadrado: " + cuadrado.calcularPerimetro() + " cm");
        System.out.println("\nÁrea del triángulo rectángulo: " + triangulo.calcularArea() + " cm^2");
        System.out.println("Perímetro del triángulo rectángulo: " + triangulo.calcularPerimetro() + " cm");
        System.out.println("Hipotenusa del triángulo rectángulo: " + triangulo.calcularHipotenusa() + " cm");
        System.out.println("Tipo de triángulo: " + triangulo.tipoTriangulo());

        scanner.close();
    }
}
