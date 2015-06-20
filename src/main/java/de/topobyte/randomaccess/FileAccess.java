// Copyright 2015 Sebastian Kuerten
//
// This file is part of unified-random-access.
//
// unified-random-access is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// unified-random-access is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with unified-random-access. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.randomaccess;

import java.io.IOException;

public interface FileAccess
{

	public void close() throws IOException;

	public void seek(long position) throws IOException;

	public long getFilePointer() throws IOException;

	public void readFully(byte[] buffer) throws IOException;

	public void readFully(byte[] buffer, int off, int length)
			throws IOException;

	public int read(byte[] buffer, int start, int length) throws IOException;

	public int read() throws IOException;

	public short readShort() throws IOException;

	public int readInt() throws IOException;

	public int readUnsignedByte() throws IOException;

	public float readFloat() throws IOException;

	public double readDouble() throws IOException;

}
