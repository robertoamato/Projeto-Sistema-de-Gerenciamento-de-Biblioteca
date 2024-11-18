import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Empréstimo de Livro");
            System.out.println("4. Devolução de Livro");
            System.out.println("5. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha

            switch (choice) {
                case 1:
                    System.out.println("Digite o título do livro:");
                    String title = scanner.nextLine();
                    System.out.println("Digite o autor do livro:");
                    String author = scanner.nextLine();
                    System.out.println("Digite o ISBN do livro:");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    library.listBooks();
                    break;
                case 3:
                    System.out.println("Digite o título do livro a ser emprestado:");
                    String loanTitle = scanner.nextLine();
                    if (library.loanBook(loanTitle)) {
                        System.out.println("Livro emprestado com sucesso!");
                    } else {
                        System.out.println("Livro não disponível ou não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o título do livro a ser devolvido:");
                    String returnTitle = scanner.nextLine();
                    if (library.returnBook(returnTitle)) {
                        System.out.println("Livro devolvido com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado ou já disponível.");
                    }
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
