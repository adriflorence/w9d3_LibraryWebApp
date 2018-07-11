package models;

public enum Genre {
    HORROR("Horror"),
    FANTASY("Fantasy"),
    FICTION("Fiction"),
    LEARNING("Learning");

    private String genreType;

    Genre(String genreType) {
        this.genreType = genreType;
    }

    public String getGenreType() {
        return genreType;
    }
}
