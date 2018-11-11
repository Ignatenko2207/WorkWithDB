package info.sjd.dao;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionToDBTest {

    @Test
    void testGetConnection() {
        Connection connection = ConnectionToDB.getConnection();

        assertNotNull(connection);

        ConnectionToDB.closeConnection(connection);
    }
}