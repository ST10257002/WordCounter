
package app.definitions;

// ST10257002 (MP)

public class Symbol {
    
    /**
     * Defines an array of character codes codes associated with this reference type.
     * 
     * @return Array of valid character codes.
     */

    public static int[] define() {
        int[] charCodes = {
            33,  // !
            34,  // "
            35,  // #
            36,  // $
            37,  // %
            38,  // &
            39,  // '
            40,  // (
            41,  // )
            42,  // *
            43,  // +
            44,  // ,
            45,  // -
            46,  // .
            47,  // /
            58,  // :
            59,  // ;
            60,  // <
            61,  // =
            62,  // >
            63,  // ?
            64,  // @
            91,  // [
            92,  // \
            93,  // ]
            94,  // ^
            95,  // _
            96,  // `
            123, // {
            124, // |
            125, // }
            126, // ~
            128, // €
            133, // …
            145, // ‘
            146, // ’
            147, // “
            148, // ”
            149, // •
            150, // –
            151, // —
            153, // ™
            161, // ¡
            162, // ¢
            163, // £
            164, // ¤
            165, // ¥
            166, // ¦
            167, // §
            169, // ©
            174, // ®
            176, // °
            177, // ±
            191, // ¿
            247, // ÷
        };    
        return charCodes;
    }
}
