public class Path {

    private String from;

    private String to;

    public Path(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Path{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
