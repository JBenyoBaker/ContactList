public class ChessPlayer extends Person
{
    private int elo;

    public ChessPlayer(String firstName, String lastName, String phoneNumber, int elo)
    {
        super(firstName, lastName, phoneNumber);
        this.elo = elo;
    }

    public int getElo()
    {
        return elo;
    }

    public String toString()
    {
        return firstName + " " + lastName + " - " + phoneNumber + " Elo: " + elo;
    }
}
