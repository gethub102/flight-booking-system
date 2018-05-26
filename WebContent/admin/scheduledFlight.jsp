<%@ include file="header.jsp" %>

<%@include file="navigation.jsp" %>
<c:if test="${sessionScope.auth != 1}">
    <c:redirect url="/auth/login.jsp"/>
</c:if>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Track</th>
                    <th scope="col">Artist</th>
                    <th scope="col">Genre</th>
                    <th scope="col">Release</th>
                    <th scope="col">Collection</th>
                    <th scope="col">Sample</th>
                    <th scope="col">Add Favorite</th>
                </tr>
                </thead>
                <tbody [appMouseAction]=myColor *ngFor="let music of musicList; let i = index">
                <tr>
                    <td>{{ i+1 }}</td>
                    <td><a
                            [routerLink]="['/music']"
                            [queryParams]="{ artistId: music.artistId, trackId: music.trackId }">
                        {{ (music.trackCensoredName.length > 20) ?
                        music.trackCensoredName.substring(0, 20) + '...'
                        : music.trackCensoredName }}</a>
                    </td>
                    <td><a [routerLink]="['/artist', music.artistId]">
                        {{ (music.artistName.length > 20) ?
                        music.artistName.substring(0, 20) + '...'
                        : music.artistName }}</a>
                    </td>
                    <td>
                        {{ music.primaryGenreName }}
                    </td>
                    <td>
                        {{ music.releaseDate.substring(0, 10) }}
                    </td>
                    <td><a [routerLink]="['/collection', music.collectionId]">
                        {{ (music.collectionCensoredName.length > 20) ?
                        music.collectionCensoredName.substring(0, 20) + '...'
                        : music.collectionCensoredName }}</a>
                    </td>
                    <td><a href="{{ music.previewUrl }}">link</a></td>

                    <td><span class="badge" (click)="onAddToFavorite(i)" >{{ music.addFavoriteStatus ? 'Added' : 'Add' }}</span></td>
                </tr>
                </tbody>
            </table>

        </div>
    </div>
</div>


<%@ include file="footer.jsp" %>