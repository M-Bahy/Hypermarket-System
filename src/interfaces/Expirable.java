package src.interfaces;
import java.time.LocalDate;

public interface Expirable {
    void setExpiryDate(LocalDate expiryDate);

    LocalDate getExpiryDate();
}
