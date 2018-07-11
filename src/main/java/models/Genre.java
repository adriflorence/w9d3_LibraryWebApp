package models;

public enum Genre {
    FANTASY("Fantasy"),
    FICTION("Fiction"),
    HORROR("Horror"),
    MEMOIRE("Memorie"),
    NON_FICTION("Non-fiction"),
    LEARNING("Learning"),
    LITERARY_REALISM("Literary realism"),
    PHILOSOPHICAL_FICTION("Philosophical fiction"),
    SATIRE("Satire"),
    SCIENCE_FICTION("Sci-Fi");

    private String genreType;

    Genre(String genreType) {
        this.genreType = genreType;
    }

    public String getGenreType() {
        return genreType;
    }
}
