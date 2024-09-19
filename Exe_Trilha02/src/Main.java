public class Main {
    public static void main(String[] args) {

        Universidade princeton = new Universidade("Princeton (Nova Jersey - Estados Unidos da América)");
        Universidade cambridge = new Universidade("Cambridge (Inglaterra)");

        Pessoa einstein = new Pessoa("Albert Einstein", "14/3/1879", princeton);
        Pessoa newton = new Pessoa("Isaac Newton", "4/1/1643", cambridge);

        System.out.println(einstein.infoUniversidade());
        System.out.println(newton.infoUniversidade());
    }
}
