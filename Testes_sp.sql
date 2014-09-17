truncate TABLE DebugMessages;
CALL acertouResultado(0, 0, 0, 0, @acertou);
CALL debug ("Problemas com resultado 0x0 e palpite 0x0", @acertou = 1);
SELECT * FROM DebugMessages;

truncate TABLE DebugMessages;
CALL acertouResultado(1, 0, 1, 0, @acertou);
CALL debug ("Problemas com resultado 1x0 e palpite 1x0", @acertou = 1);
SELECT * FROM DebugMessages;

truncate TABLE DebugMessages;
CALL acertouResultado(0, 1, 0, 1, @acertou);
CALL debug ("Problemas com resultado 0x1 e palpite 0x1", @acertou = 1);
SELECT * FROM DebugMessages;

truncate TABLE DebugMessages;
CALL acertouResultado(3, 1, 4, 2, @acertou);
CALL debug ("Problemas com resultado 3x1 e palpite 4x2", @acertou = 1);
SELECT * FROM DebugMessages;

truncate TABLE DebugMessages;
CALL acertouResultado(1, 0, 0, 1, @acertou);
CALL debug ("Problemas com resultado 1x0 e palpite 0x1", @acertou = 0);
SELECT * FROM DebugMessages;