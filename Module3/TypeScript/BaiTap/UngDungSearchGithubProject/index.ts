function search(key) {
    interface ISingleRepo {
        name: string;
    }

    interface IRepos {
        items: Array<ISingleRepo>;
    }

    let keyword: String = 'https://api.github.com/search/repositories?q=' + key;

    async function fetchRepo(): Promise<Array<ISingleRepo>> {
        let res: Response | IRepos = await fetch(keyword);
        res = await res.json() as IRepos;
        return res.items;
    }

    async function main() {
        $("table").children().remove();
        const res = await fetchRepo();
        $("table").append('<tr style="background-color: grey">\n'
            + '<td>Tên project</td>\n'
            + '<td>Mô tả</td>\n'
            + '<td>Ngôn ngữ</td>\n'
            + '<td>Đường dẫn</td>\n'
            + '<td>Lượt xem</td>\n'
            + '</tr>')
        res.forEach((item: any) => {
            console.log(item)
            $("table").append('<tr>'
                + '<td>' + item.name + '</td>'
                + '<td>' + item.description + '</td>'
                + '<td>' + item.language + '</td>'
                + '<td><a href="' + item.html_url + '">' + item.html_url + '</a></td>'
                + '<td>' + item.watchers + '</td>'
                + '</tr>');
        });
    }

    main();
}

