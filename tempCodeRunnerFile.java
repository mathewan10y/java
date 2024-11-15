void perm(char ch[], int index) {

        if (index == ch.length) {
            int c = 0;
            StringTokenizer tk = new StringTokenizer(k);
            while (tk.hasMoreTokens()) {
                if (((String) tk.nextToken()).equals(new String(ch))) {
                    c = 1;
                }
            }
            if (c == 0) {
                ja.append(new String(ch) + "\n");
                k = k + (new String(ch) + "\n");
                return;
            }
        }

        for (int i = index; i < ch.length; i++) {
            swap(ch, index, i);
            perm(ch, index + 1);
            swap(ch, index, i);
        }

    }