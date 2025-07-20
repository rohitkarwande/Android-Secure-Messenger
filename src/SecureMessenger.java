import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * A conceptual model of a secure messaging application.
 * This simulation focuses on the logic of message creation, encryption,
 * and decryption, rather than the Android UI or network layers.
 */
public class SecureMessenger {

    // --- Inner Classes to Model the System ---

    /**
     * Represents a single message in the system.
     */
    static class Message {
        String messageId;
        String senderId;
        String receiverId;
        String content; // In a real app, this would be the encrypted content
        long timestamp;

        public Message(String senderId, String receiverId, String content) {
            this.messageId = UUID.randomUUID().toString();
            this.senderId = senderId;
            this.receiverId = receiverId;
            this.content = content;
            this.timestamp = System.currentTimeMillis();
        }

        @Override
        public String toString() {
            return "Message [from=" + senderId + ", to=" + receiverId + ", content='" + content + "']";
        }
    }

    /**
     * Simulates the core service that handles encryption and decryption.
     * A real implementation would use a robust cryptographic library like the Signal Protocol.
     */
    static class MessagingService {
        
        // This is a placeholder for a real encryption algorithm.
        // We use Base64 encoding to simulate the transformation of data.
        public String encrypt(String plainText) {
            System.out.println("    [ENCRYPTING]... Original: '" + plainText + "'");
            String encrypted = Base64.getEncoder().encodeToString(plainText.getBytes());
            System.out.println("    [ENCRYPTED] -> '" + encrypted + "'");
            return encrypted;
        }

        // This is a placeholder for a real decryption algorithm.
        public String decrypt(String encryptedText) {
            System.out.println("    [DECRYPTING]... Encrypted: '" + encryptedText + "'");
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
            String decrypted = new String(decodedBytes);
            System.out.println("    [DECRYPTED] -> '" + decrypted + "'");
            return decrypted;
        }

        /**
         * Simulates a user sending a message.
         * The message content is encrypted before being "sent".
         */
        public Message sendMessage(String senderId, String receiverId, String plainTextContent) {
            System.out.println("\n" + senderId + " is sending a message to " + receiverId + "...");
            String encryptedContent = encrypt(plainTextContent);
            // In a real app, this message object would be sent over the network.
            return new Message(senderId, receiverId, encryptedContent);
        }
    }

    // --- Main Simulation ---

    public static void main(String[] args) {
        // 1. Initialize the core service.
        MessagingService service = new MessagingService();

        // 2. Define our users.
        String aliceId = "Alice";
        String bobId = "Bob";

        // 3. Alice sends a message to Bob.
        // The service handles the "encryption" and creates the message object.
        Message sentMessage = service.sendMessage(aliceId, bobId, "Hello Bob, this is a secret message!");

        // --- Simulation of the message being received by Bob's device ---
        System.out.println("\nBob's device receives the message object: " + sentMessage.toString());

        // 4. Bob's device uses the service to decrypt the message content.
        String receivedContent = service.decrypt(sentMessage.content);

        // 5. Display the final, decrypted message on Bob's screen.
        System.out.println("\n--- On Bob's Screen ---");
        System.out.println("From: " + sentMessage.senderId);
        System.out.println("Message: " + receivedContent);
        System.out.println("-----------------------");
    }
}
