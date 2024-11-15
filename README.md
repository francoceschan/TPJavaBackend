# Empresa de transporte de pasajeros 
Se desea construir un sistema para gestionar viajes y colectivos asociados a los mismos.
Existirá la posibilidad de acceder como Pasajero o Administrativo, el Administrativo podrá crear viajes, colectivos y ciudades, el Pasajero podrá comprar un boleto para un viaje y escribir una reseña del mismo.


# ABMC Simple
- **Pasajero**
- **Administrativo**
- **Colectivo**
- **Ciudad**

# ABMC Dependiente
- **Viaje**
- **Reseña**

# CU NO-ABMC
- **Comprar boleto:** El pasajero selecciona un viaje disponible y compra un boleto.
- **Escribir reseña de un viaje realizado.**

# Listado Simple
- **Listar colectivos** [Acceso: administrativo]
- **Listar ciudades** [Acceso: administrativo]
- **Listar viajes** [Acceso: invitado, pasajero y administrativo]
- **Listar reseñas** [Acceso: invitado, pasajero y administrativo]

# Listado Complejo
- **Listar viajes en un rango de fechas, por precio, origen y destino** [Acceso: invitado, pasajero y administrativo]
- **Listar colectivos libres para una fecha** [Acceso: administrativo]
- **Listar boletos comprados** [Acceso: pasajero]

# Niveles de Acceso
- **Nivel de acceso 1:** Pasajero
- **Nivel de acceso 2:** Administrativo

