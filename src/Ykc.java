// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ykc extends KaitaiStruct {
    public static Ykc fromFile(String fileName) throws IOException {
        return new Ykc(new KaitaiStream(fileName));
    }

    public Ykc(KaitaiStream _io) throws IOException {
        super(_io);
        this._root = this;
        _parse();
    }

    public Ykc(KaitaiStream _io, KaitaiStruct _parent) throws IOException {
        super(_io);
        this._parent = _parent;
        this._root = this;
        _parse();
    }

    public Ykc(KaitaiStream _io, KaitaiStruct _parent, Ykc _root) throws IOException {
        super(_io);
        this._parent = _parent;
        this._root = _root;
        _parse();
    }
    private void _parse() throws IOException {
        this.magic = _io.ensureFixedContents(8, new byte[] { 89, 75, 67, 48, 48, 49, 0, 0 });
        this.magic2 = _io.ensureFixedContents(8, new byte[] { 24, 0, 0, 0, 0, 0, 0, 0 });
        this.headerOfs = _io.readU4le();
        this.headerLen = _io.readU4le();
    }
    public static class Header extends KaitaiStruct {
        public static Header fromFile(String fileName) throws IOException {
            return new Header(new KaitaiStream(fileName));
        }

        public Header(KaitaiStream _io) throws IOException {
            super(_io);
            _parse();
        }

        public Header(KaitaiStream _io, KaitaiStruct _parent) throws IOException {
            super(_io);
            this._parent = _parent;
            _parse();
        }

        public Header(KaitaiStream _io, KaitaiStruct _parent, Ykc _root) throws IOException {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _parse();
        }
        private void _parse() throws IOException {
            this.entries = new ArrayList<FileEntry>();
            while (!_io.isEof()) {
                this.entries.add(new FileEntry(_io, this, _root));
            }
        }
        private ArrayList<FileEntry> entries;
        private Ykc _root;
        private KaitaiStruct _parent;
        public ArrayList<FileEntry> entries() { return entries; }
        public Ykc _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class FileEntry extends KaitaiStruct {
        public static FileEntry fromFile(String fileName) throws IOException {
            return new FileEntry(new KaitaiStream(fileName));
        }

        public FileEntry(KaitaiStream _io) throws IOException {
            super(_io);
            _parse();
        }

        public FileEntry(KaitaiStream _io, KaitaiStruct _parent) throws IOException {
            super(_io);
            this._parent = _parent;
            _parse();
        }

        public FileEntry(KaitaiStream _io, KaitaiStruct _parent, Ykc _root) throws IOException {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _parse();
        }
        private void _parse() throws IOException {
            this.filenameOfs = _io.readU4le();
            this.filenameLen = _io.readU4le();
            this.bodyOfs = _io.readU4le();
            this.bodyLen = _io.readU4le();
            this.unknown5 = _io.readU4le();
        }
        private String filename;
        public String filename() throws IOException {
            if (filename != null)
                return filename;
            KaitaiStream io = _root._io();
            long _pos = io.pos();
            io.seek(filenameOfs());
            this.filename = io.readStrByteLimit(filenameLen(), "SJIS");
            io.seek(_pos);
            return filename;
        }
        private byte[] body;
        public byte[] body() throws IOException {
            if (body != null)
                return body;
            KaitaiStream io = _root._io();
            long _pos = io.pos();
            io.seek(bodyOfs());
            this.body = io.readBytes(bodyLen());
            io.seek(_pos);
            return body;
        }
        private long filenameOfs;
        private long filenameLen;
        private long bodyOfs;
        private long bodyLen;
        private long unknown5;
        private Ykc _root;
        private KaitaiStruct _parent;
        public long filenameOfs() { return filenameOfs; }
        public long filenameLen() { return filenameLen; }
        public long bodyOfs() { return bodyOfs; }
        public long bodyLen() { return bodyLen; }
        public long unknown5() { return unknown5; }
        public Ykc _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    private Header header;
    public Header header() throws IOException {
        if (header != null)
            return header;
        long _pos = _io.pos();
        _io.seek(headerOfs());
        this._raw_header = _io.readBytes(headerLen());
        KaitaiStream _io__raw_header = new KaitaiStream(_raw_header);
        this.header = new Header(_io__raw_header, this, _root);
        _io.seek(_pos);
        return header;
    }
    private byte[] magic;
    private byte[] magic2;
    private long headerOfs;
    private long headerLen;
    private Ykc _root;
    private KaitaiStruct _parent;
    private byte[] _raw_header;
    public byte[] magic() { return magic; }
    public byte[] magic2() { return magic2; }
    public long headerOfs() { return headerOfs; }
    public long headerLen() { return headerLen; }
    public Ykc _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
    public byte[] _raw_header() { return _raw_header; }
}
