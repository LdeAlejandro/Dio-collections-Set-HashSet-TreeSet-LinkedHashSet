package br.com.dio.collection.set;
import java.util.* ;

 /*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/


public class ExercioProposto02 {

    public static void main(String[] args) {

        // Criar lista e ordernar por inserção
        Set<LinguagemFavorita> minhasLinguagensFavoritas = new LinkedHashSet<>(
                Arrays.asList( // criar array de linguagens favoritas com os atributos nome, anoDeCriacao e IDE
                        new LinguagemFavorita("Java", 1995, "Intellij"),
                        new LinguagemFavorita("Python", 1991, "Pycharm"),
                        new LinguagemFavorita("JavaScript", 1995, "vs code"),
                        new LinguagemFavorita("C#", 1994, "Visual studio commnunity")
                )
        );
        System.out.println("=============================== Ordem de Inserção ===============================");
        for (LinguagemFavorita linguagem : minhasLinguagensFavoritas) {
            System.out.println(linguagem);
        }

        // Ordem natural (nome)
        Set <LinguagemFavorita> minhasLinguagensFavoritasOrdemNatural = new TreeSet<>(minhasLinguagensFavoritas);
        System.out.println("=============================== Ordem de natural (nome) ===============================");
        for (LinguagemFavorita linguagem : minhasLinguagensFavoritasOrdemNatural) {
            System.out.println(linguagem);
        }

        // Ordem por ide
        System.out.println("=============================== Ordem por ide ===============================");

        Set <LinguagemFavorita> minhasLinguagensFavoritasOrdemPorIde = new TreeSet<>(new ComparatorIde());
        minhasLinguagensFavoritasOrdemPorIde.addAll(minhasLinguagensFavoritas);
        for (LinguagemFavorita linguagem : minhasLinguagensFavoritasOrdemPorIde) {
            System.out.println(linguagem);
        }

        // Ordem por ano de criacao e nome
        System.out.println("=============================== Ordem por ano de criacao e nome ===============================");
        Set <LinguagemFavorita> minhasLinguagensFavoritasOrdemAnoDeCriacaoNome = new TreeSet<>(new ComparatorAnoDeCriacaoNome());
        minhasLinguagensFavoritasOrdemAnoDeCriacaoNome.addAll(minhasLinguagensFavoritas);

        for (LinguagemFavorita linguagem : minhasLinguagensFavoritasOrdemAnoDeCriacaoNome) {
            System.out.println(linguagem);
        }

        // Ordem por nome, ano de criacao e ide
        System.out.println("=============================== Ordem por nome, ano de criacao e ide ===============================");
        Set <LinguagemFavorita> minhasLinguagensFavoritasOrdemNomeIdeAnoDeCriacao = new TreeSet<>(new ComparatorNomeIdeAnoDeCriacao());
        minhasLinguagensFavoritasOrdemNomeIdeAnoDeCriacao.addAll(minhasLinguagensFavoritas);

        for (LinguagemFavorita linguagem : minhasLinguagensFavoritasOrdemNomeIdeAnoDeCriacao) {
            System.out.println(linguagem);
        }

        //Exibir linguaguens favoritas
        System.out.println("=============================== Linguagens favoritas ===============================");
        for (LinguagemFavorita linguagem : minhasLinguagensFavoritas) {
            System.out.println(linguagem.nome);
        }
    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    public String nome;
    public Integer anoDeCriacao;
    public String ide;

    public LinguagemFavorita(String nome, int anoDeCriacao,  String ide) {
        this.ide = ide;
        this.anoDeCriacao = anoDeCriacao;
        this.nome = nome;
    }


    @Override
    //retorna o nome da linguagem favorita
    public int compareTo(LinguagemFavorita LinguagemFavorita) {
        return this.nome.compareToIgnoreCase(LinguagemFavorita.nome); // retorna o nome da linguagem favorita
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // se for o mesmo objeto retorna true
        if (o == null || getClass() != o.getClass()) return false; // se for nulo ou diferente da classe retorna false
        LinguagemFavorita that = (LinguagemFavorita) o; // conversao de object para LinguagemFavorita
        return nome.equals(that.nome); // retorna true se os nomes forem iguais
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome); // retorna o hashcode do nome
    }

    @Override
    public String toString() {
        return "LinguagemFavorita{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }
}

class ComparatorIde implements Comparator<LinguagemFavorita> {
    // retorna o IDE da Linguagem favorita
    @Override
    public int compare(LinguagemFavorita LinguagemFavorita1, LinguagemFavorita LinguagemFavorita2) {
        return LinguagemFavorita1.ide.compareToIgnoreCase(LinguagemFavorita2.ide); // retorna o IDE da Linguagem favorita ignora o case sensitive
    }
}

class ComparatorAnoDeCriacaoNome implements Comparator<LinguagemFavorita> {
    // retorna o ano de criacao e nome da Linguagem favorita
    public int compare(LinguagemFavorita LinguagemFavorita1, LinguagemFavorita LinguagemFavorita2) {
        int anoDeCriacao = Integer.compare(LinguagemFavorita1.anoDeCriacao, LinguagemFavorita2.anoDeCriacao); // retorna o nome da Linguagem favorita ignora o case sensitive
        if(anoDeCriacao != 0) return anoDeCriacao; // se o ano de criacao for diferente de 0 retorna o ano de criacao

        return LinguagemFavorita1.nome.compareToIgnoreCase(LinguagemFavorita2.nome); // retorna o nome da Linguagem favorita ignora o case sensitive
    }
}

class ComparatorNomeIdeAnoDeCriacao implements Comparator<LinguagemFavorita> {
    // retorna o nome, ide e ano de criacao da Linguagem favorita
    public int compare(LinguagemFavorita LinguagemFavorita1, LinguagemFavorita LinguagemFavorita2) {
        int nome = LinguagemFavorita1.nome.compareToIgnoreCase(LinguagemFavorita2.nome);  // retorna o nome da Linguagem favorita ignora o case sensitive
        int anoDeCriacao = Integer.compare(LinguagemFavorita1.anoDeCriacao, LinguagemFavorita2.anoDeCriacao); // retorna o ano de criacao
        if (nome != 0) return nome; // se o nome for diferente de 0 retorna o nome
        if(anoDeCriacao != 0) return anoDeCriacao; // se o ano de criacao for diferente de 0 retorna o ano de criacao
        return LinguagemFavorita1.ide.compareToIgnoreCase(LinguagemFavorita2.ide);
    }
}