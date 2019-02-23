package hotelmanagement;

public interface User {
    void book(String room_type);
    void cancel(int room_no);
}
