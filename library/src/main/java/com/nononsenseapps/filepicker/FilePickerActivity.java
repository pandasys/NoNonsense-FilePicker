/*
 * Copyright (c) 2014 Jonas Kalderstam
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.nononsenseapps.filepicker;

import java.io.File;

public class FilePickerActivity extends AbstractFilePickerActivity<File> {

    public FilePickerActivity() {
        super();
    }

    @Override
    protected String getWindowTitle() {
        final int res;
        if (onlyDirs) {
            res = R.plurals.select_dir;
        } else {
            res = R.plurals.select_dir_or_file;
        }

        final int count;
        if (allowMultiple) {
            count = 99;
        } else {
            count = 1;
        }

        return getResources().getQuantityString(res, count);
    }

    @Override
    protected AbstractFilePickerFragment<File> getFragment(final String startPath, final boolean onlyDirs, final boolean allowMultiple) {
        AbstractFilePickerFragment fragment = new FilePickerFragment();
        fragment.setArgs(startPath, onlyDirs, allowMultiple);
        return fragment;
    }
}
