package collections;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.*;

public class Main {
    public static void main(String[] args) {
        String s = "JCeyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsYW55YWdlLVtST0xFX1NUT1JFX09VVF9TQVZFLCBST0xFX1NUT1JFX0NIRUNLX0RFTEVURSwgUk9MRV9BVVRIX1JPTEVfVVBEQVRFLCBST0xFX1BST0NFU1NfUFJPQ0VTU19VUERBVEUsIFJPTEVfUFJPQ0VTU19EQVRBX0lOX1BSSU5ULCBST0xFX0lRQywgUk9MRV9BVVRIX1VTRVJfU0FWRSwgUk9MRV9QUk9DRVNTX0RBVEFfSU5fQVVESVQsIFJPTEVfU1RPUkVfUkVEX0xJU1RTX1BSSU5ULCBST0xFX1NUT1JFX1NUT0NLX1VQREFURSwgUk9MRV9TVE9SRV9SRURfTElTVFNfQVVESVQsIFJPTEVfUFJPQ0VTU19QUk9DRVNTX0RPV05MT0FELCBST0xFX1RFU1RFUiwgUk9MRV9BVVRIX0RFUEFSVE1FTlRfRE9XTkxPQUQsIFJPTEVfQVVUSF9ST0xFX0RPV05MT0FELCBST0xFX0FVVEhfQVVUSF9QUklOVCwgUk9MRV9QUk9DRVNTX0JBU0VfREFUQV9TQVZFLCBST0xFX1BST0NFU1NfVEFTS19VUERBVEUsIFJPTEVfUFJPQ0VTU19CQVNFX0RBVEFfVVBEQVRFLCBST0xFX0FVVEhfTUVOVV9TQVZFLCBST0xFX1NBTVBMRVIsIFJPTEVfUFJPQ0VTU19EQVRBX0lOX1VQREFURSwgUk9MRV9BVVRIX0RFUEFSVE1FTlRfREVMRVRFLCBST0xFX0FVVEhfVVNFUl9VUExPQUQsIFJPTEVfU1RPUkVfQ0hFQ0tfRE9XTkxPQUQsIFJPTEVfQVVUSF9NRU5VX0FVRElULCBST0xFX1NUT1JFX0lOX1NBVkUsIFJPTEVfQVVUSF9ST0xFX1VQTE9BRCwgUk9MRV9BVVRIX0FVVEhfQVVESVQsIFJPTEVfZGVmYXVsdF9ERUxFVEUsIFJPTEVfQVVUSF9VU0VSX1BSSU5ULCBST0xFX0FVVEhfVVNFUl9ERUxFVEUsIFJPTEVfUFJPQ0VTU19CQVNFX0RBVEFfUVVFUlksIFJPTEVfU1RPUkVfQ0hFQ0tfU0FWRSwgUk9MRV9BVVRIX0FVVEhfREVMRVRFLCBST0xFX0FVVEhfQVVUSF9VUERBVEUsIFJPTEVfUFJPQ0VTU19CQVNFX0RBVEFfUFJJTlQsIFJPTEVfQVVUSF9NRU5VX0RPV05MT0FELCBST0xFX0FVVEhfREVQQVJUTUVOVF9BVURJVCwgUk9MRV9BVVRIX0RFUEFSVE1FTlRfUFJJTlQsIFJPTEVfZGVmYXVsdF9RVUVSWSwgUk9MRV9QUk9DRVNTX0RBVEFfSU5fVVBMT0FELCBST0xFX1BST0NFU1NfUFJPQ0VTU19TQVZFLCBST0xFX1BST0NFU1NfUFJPQ0VTU19VUExPQUQsIFJPTEVfUFJPQ0VTU19EQVRBX0lOX0RPV05MT0FELCBST0xFX2RlZmF1bHRfUFJJTlQsIFJPTEVfQVVUSF9ERVBBUlRNRU5UX1NBVkUsIFJPTEVfU1RPUkVfU1RPQ0tfRE9XTkxPQUQsIFJPTEVfUFJPQ0VTU19EQVRBX0lOX1NBVkUsIFJPTEVfUFJPQ0VTU19CQVNFX0RBVEFfREVMRVRFLCBST0xFX0FVVEhfREVQQVJUTUVOVF9VUERBVEUsIFJPTEVfU1RPUkVfSU5fUFJJTlQsIFJPTEVfUFJPQ0VTU19CQVNFX0RBVEFfVVBMT0FELCBST0xFX1BST0NFU1NfVEFTS19VUExPQUQsIFJPTEVfU1RPUkVfSU5fREVMRVRFLCBST0xFX2RlZmF1bHRfVVBEQVRFLCBST0xFX1BST0NFU1NfREFUQV9JTl9ERUxFVEUsIFJPTEVfU1RPUkVfT1VUX1VQREFURSwgUk9MRV9BRE1JTiwgUk9MRV9TVE9SRV9JTl9VUExPQUQsIFJPTEVfUFJPQ0VTU19UQVNLX0RFTEVURSwgUk9MRV9TVE9SRV9DSEVDS19QUklOVCwgUk9MRV9BVVRIX0RFUEFSVE1FTlRfUVVFUlksIFJPTEVfU1RPUkVfT1VUX1FVRVJZLCBST0xFX0FVVEhfUk9MRV9ERUxFVEUsIFJPTEVfU1RPUkVfQ0hFQ0tfVVBEQVRFLCBST0xFX1NUT1JFX1NUT0NLX0FVRElULCBST0xFX1BST0NFU1NfVEFTS19BVURJVCwgUk9MRV9TVE9SRV9SRURfTElTVFNfVVBMT0FELCBST0xFX0FVVEhfQVVUSF9ET1dOTE9BRCwgUk9MRV9TVE9SRV9PVVRfRE9XTkxPQUQsIFJPTEVfU1RPUkVfU1RPQ0tfUFJJTlQsIFJPTEVfU1RPUkVfT1VUX1VQTE9BRCwgUk9MRV9TVE9SRV9TVE9DS19ERUxFVEUsIFJPTEVfUFJPQ0VTU19UQVNLX1BSSU5ULCBST0xFX1BST0NFU1NfQkFTRV9EQVRBX0RPV05MT0FELCBST0xFX1BST0NFU1NfUFJPQ0VTU19ERUxFVEUsIFJPTEVfU1RPUkVfUkVEX0xJU1RTX0RPV05MT0FELCBST0xFX1NUT1JFX1NUT0NLX1FVRVJZLCBST0xFX1NUT1JFX0lOX0RPV05MT0FELCBST0xFX1NUT1JFX09VVF9QUklOVCwgUk9MRV9BVVRIX0FVVEhfU0FWRSwgUk9MRV9BVVRIX0FVVEhfVVBMT0FELCBST0xFX0FVVEhfREVQQVJUTUVOVF9VUExPQUQsIFJPTEVfU1RPUkVfQ0hFQ0tfUVVFUlksIFJPTEVfUFJPQ0VTU19QUk9DRVNTX0FVRElULCBST0xFX0FVVEhfVVNFUl9ET1dOTE9BRCwgUk9MRV9TVE9SRV9PVVRfQVVESVQsIFJPTEVfU1RPUkVfUkVEX0xJU1RTX1NBVkUsIFJPTEVfZGVmYXVsdF9VUExPQUQsIFJPTEVfQVVUSF9ST0xFX1BSSU5ULCBST0xFX1NUT1JFX0lOX1FVRVJZLCBST0xFX1NUT1JFX0lOX1VQREFURSwgUk9MRV9kZWZhdWx0X0FVRElULCBST0xFX0FVVEhfTUVOVV9VUERBVEUsIFJPTEVfU1RPUkVfU1RPQ0tfU0FWRSwgUk9MRV9TVE9SRV9PVVRfREVMRVRFLCBST0xFX2RlZmF1bHRfU0FWRSwgUk9MRV9QUk9DRVNTX1RBU0tfRE9XTkxPQUQsIFJPTEVfU1RPUkVfUkVEX0xJU1RTX1VQREFURSwgUk9MRV9BVVRIX01FTlVfUFJJTlQsIFJPTEVfU1RPUkVfU1RPQ0tfVVBMT0FELCBST0xFX1NUT1JFX1JFRF9MSVNUU19ERUxFVEUsIFJPTEVfUFJPQ0VTU19CQVNFX0RBVEFfQVVESVQsIFJPTEVfQVVUSF9ST0xFX0FVRElULCBST0xFX0FVVEhfTUVOVV9RVUVSWSwgUk9MRV9QUk9DRVNTX1RBU0tfU0FWRSwgUk9MRV9BVVRIX1JPTEVfUVVFUlksIFJPTEVfU1RPUkVfQ0hFQ0tfQVVESVQsIFJPTEVfQVVUSF9VU0VSX0FVRElULCBST0xFX1BST0NFU1NfUFJPQ0VTU19RVUVSWSwgUk9MRV9kZWZhdWx0X0RPV05MT0FELCBST0xFX1NUT1JFX0lOX0FVRElULCBST0xFX0FVVEhfVVNFUl9VUERBVEUsIFJPTEVfQVVUSF9ST0xFX1NBVkUsIFJPTEVfQVVUSF9VU0VSX1FVRVJZLCBST0xFX1BST0NFU1NfUFJPQ0VTU19QUklOVCwgUk9MRV9BVVRIX01FTlVfREVMRVRFLCBST0xFX0FVVEhfQVVUSF9RVUVSWSwgUk9MRV9TVE9SRV9DSEVDS19VUExPQUQsIFJPTEVfQVVUSF9NRU5VX1VQTE9BRCwgUk9MRV9TVE9SRV9SRURfTElTVFNfUVVFUlksIFJPTEVfUFJPQ0VTU19EQVRBX0lOX1FVRVJZLCBST0xFX1BST0NFU1NfVEFTS19RVUVSWV0iLCJ1c2VybmFtZSI6ImxhbnlhZ2UiLCJleHAiOjE1NTA4MjQyMDYsIm5iZiI6MTU1MDczNzgwNn0.ac3b0W-sxhbqERc8dKmrK1OXKTqaTlwUCwsG2oMEwE5MhceRk0Wv5pnpTuXwzip5oTvMclvCQqS2QtKWWkExFQ";

        //System.out.println("original length : " + s.length());
        //long start = System.currentTimeMillis();
        //String zipString = ZipUtils.zip(s);
        //System.out.println("zip cost : " + (System.currentTimeMillis() - start) + "ms");
        //System.out.println("zip length : " + zipString.length());
        //start = System.currentTimeMillis();
        //String gzipString = ZipUtils.gzip(s);
        //System.out.println("gzip cost : " + (System.currentTimeMillis() - start) + "ms");
        //System.out.println("gzip length : " + gzipString.length());
        //
        //start = System.currentTimeMillis();
        //String unzipString = ZipUtils.unzip(zipString);
        //System.out.println(unzipString.length());
        //System.out.println("unzip cost : " + (System.currentTimeMillis() - start) + "ms");
        //
        //start = System.currentTimeMillis();
        //String gunzipString = ZipUtils.gunzip(gzipString);
        //System.out.println(gunzipString.length());
        //System.out.println(gunzipString);
        //System.out.println("gunzip cost : " + (System.currentTimeMillis() - start) + "ms");
    }
}


//class ZipUtils {
//
//    public static String gzip(String primStr) {
//        if (primStr == null || primStr.length() == 0) {
//            return primStr;
//        }
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        GZIPOutputStream gzip = null;
//        try {
//            gzip = new GZIPOutputStream(out);
//            gzip.write(primStr.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (gzip != null) {
//                try {
//                    gzip.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//
//        return new sun.misc.BASE64Encoder().encode(out.toByteArray());
//    }
//
//
//    public static String gunzip(String compressedStr) {
//        if (compressedStr == null) {
//            return null;
//        }
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        ByteArrayInputStream in = null;
//        GZIPInputStream ginzip = null;
//        byte[] compressed = null;
//        String decompressed = null;
//        try {
//            compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
//            in = new ByteArrayInputStream(compressed);
//            ginzip = new GZIPInputStream(in);
//
//            byte[] buffer = new byte[1024];
//            int offset = -1;
//            while ((offset = ginzip.read(buffer)) != -1) {
//                out.write(buffer, 0, offset);
//            }
//            decompressed = out.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (ginzip != null) {
//                try {
//                    ginzip.close();
//                } catch (IOException e) {
//                }
//            }
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException e) {
//                }
//            }
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                }
//            }
//        }
//
//        return decompressed;
//    }
//
//    public static final String zip(String str) {
//        if (str == null)
//            return null;
//        byte[] compressed;
//        ByteArrayOutputStream out = null;
//        ZipOutputStream zout = null;
//        String compressedStr = null;
//        try {
//            out = new ByteArrayOutputStream();
//            zout = new ZipOutputStream(out);
//            zout.putNextEntry(new ZipEntry("0"));
//            zout.write(str.getBytes());
//            zout.closeEntry();
//            compressed = out.toByteArray();
//            compressedStr = new sun.misc.BASE64Encoder().encodeBuffer(compressed);
//        } catch (IOException e) {
//            compressed = null;
//        } finally {
//            if (zout != null) {
//                try {
//                    zout.close();
//                } catch (IOException e) {
//                }
//            }
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                }
//            }
//        }
//        return compressedStr;
//    }
//
//    public static final String unzip(String compressedStr) {
//        if (compressedStr == null) {
//            return null;
//        }
//
//        ByteArrayOutputStream out = null;
//        ByteArrayInputStream in = null;
//        ZipInputStream zin = null;
//        String decompressed = null;
//        try {
//            byte[] compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
//            out = new ByteArrayOutputStream();
//            in = new ByteArrayInputStream(compressed);
//            zin = new ZipInputStream(in);
//            zin.getNextEntry();
//            byte[] buffer = new byte[1024];
//            int offset = -1;
//            while ((offset = zin.read(buffer)) != -1) {
//                out.write(buffer, 0, offset);
//            }
//            decompressed = out.toString();
//        } catch (IOException e) {
//            decompressed = null;
//        } finally {
//            if (zin != null) {
//                try {
//                    zin.close();
//                } catch (IOException e) {
//                }
//            }
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException e) {
//                }
//            }
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                }
//            }
//        }
//        return decompressed;
//    }
//}