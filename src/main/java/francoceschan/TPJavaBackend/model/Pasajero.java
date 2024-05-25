package francoceschan.TPJavaBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "pasajeros")
public class Pasajero extends Usuario{
}
