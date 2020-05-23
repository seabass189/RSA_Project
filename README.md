# RSA_Project
Project that can generate keys, encrypt, and decrypt

HOW TO COMPILE:

    javac RSAGenKey.java FileHandler.java
    
    javac RSAEncrypt.java FileHandler.java
    
    javac RSADecrypt.java FileHandler.java

HOW TO RUN:

    java RSAGenKey [key_destination_file_path]
    
    java RSAEncrypt [source_file_path] [destination_file_path] [key_file_path]
    
    java RSAEncrypt [destination_file_path] [source_file_path] [key_file_path]
