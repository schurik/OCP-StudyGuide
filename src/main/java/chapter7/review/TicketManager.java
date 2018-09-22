package chapter7.review;

public class TicketManager {

    private TicketManager() {
        super();
    }

    private static TicketManager instance;

    public static synchronized TicketManager getInstance() {

        if (instance == null) instance = new TicketManager();
        return instance;
    }

    private int tickets;

    public int getTicketCount() {
        return tickets;
    }

    public void mackeTicketsAvailable(int value) {
        tickets += value;
    }

    public void sellTickets(int value) {
        synchronized (this) {
            tickets -= value;
        }
    }
}
