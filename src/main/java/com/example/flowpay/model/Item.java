    package com.example.flowpay.model;

    import java.util.Objects;

    public class Item {
        private Long id;
        private String nome;

        public Item() {
        }

        public Item(Long id, String nome) {
            this.id = id;
            this.nome = nome;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        // Método toString()
        @Override
        public String toString() {
            return "Item{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return Objects.equals(id, item.id) && Objects.equals(nome, item.nome);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, nome);
        }
    }
